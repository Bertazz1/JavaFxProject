package controller;

import dao.ProdutoDAO;
import dao.CategoriaDAO;
import model.Produto;
import model.Categoria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

public class ProdutosController {

    @FXML private TableView<Produto> tableView;
    @FXML private TableColumn<Produto, Integer> colId;
    @FXML private TableColumn<Produto, String> colNome;
    @FXML private TableColumn<Produto, Double> colPreco;
    @FXML private TableColumn<Produto, Integer> colEstoque;
    @FXML private TableColumn<Produto, String> colCategoria;

    @FXML private TextField txtNome, txtDescricao, txtPreco, txtEstoque;
    @FXML private ComboBox<Categoria> cbCategoria;

    private ObservableList<Produto> produtosList;
    private ObservableList<Categoria> categoriasList;
    private ProdutoDAO produtoDAO;
    private CategoriaDAO categoriaDAO;

    @FXML
    public void initialize() {
        produtoDAO = new ProdutoDAO();
        categoriaDAO = new CategoriaDAO();

        produtosList = FXCollections.observableArrayList();
        categoriasList = FXCollections.observableArrayList();

        tableView.setItems(produtosList);
        cbCategoria.setItems(categoriasList);

        configurarComboBoxCategoria();


        carregarCategorias();
        carregarProdutos();

        // Listener para seleção na tabela
        tableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarProduto(newValue));
    }


    private void configurarComboBoxCategoria() {
        cbCategoria.setConverter(new StringConverter<Categoria>() {
            @Override
            public String toString(Categoria categoria) {
                return categoria == null ? null : categoria.getNome();
            }

            @Override
            public Categoria fromString(String string) {
                // Não é necessário para este caso
                return null;
            }
        });
    }


    private void carregarCategorias() {
        try {
            categoriasList.clear();
            categoriasList.addAll(categoriaDAO.read());
        } catch (Exception e) {
            mostrarAlerta("Erro ao carregar categorias: " + e.getMessage());
        }
    }


    private void carregarProdutos() {
        try {
            produtosList.clear();
            produtosList.addAll(produtoDAO.read()); // O DAO já faz a JOIN
        } catch (Exception e) {
            mostrarAlerta("Erro ao carregar produtos: " + e.getMessage());
        }
    }


    private void selecionarProduto(Produto produto) {
        if (produto != null) {
            txtNome.setText(produto.getNome());
            txtDescricao.setText(produto.getDescricao());
            txtPreco.setText(String.valueOf(produto.getPreco()));
            txtEstoque.setText(String.valueOf(produto.getEstoque()));

            for (Categoria c : cbCategoria.getItems()) {
                if (c.getId() == produto.getCategoriaId()) {
                    cbCategoria.setValue(c);
                    break;
                }
            }
        }
    }

    @FXML
    private void handleSalvar() {
        if (validarCampos()) {
            try {
                Produto produto = new Produto();
                preencherProdutoDoForm(produto);

                produtoDAO.create(produto);
                carregarProdutos();
                limparCampos();
                mostrarAlerta("Produto salvo com sucesso!", Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                mostrarAlerta("Erro ao salvar produto: " + e.getMessage());
            }
        }
    }

    @FXML
    private void handleAtualizar() {
        Produto produtoSelecionado = tableView.getSelectionModel().getSelectedItem();
        if (produtoSelecionado != null && validarCampos()) {
            try {
                preencherProdutoDoForm(produtoSelecionado);

                produtoDAO.update(produtoSelecionado);
                carregarProdutos();
                limparCampos();
                mostrarAlerta("Produto atualizado com sucesso!", Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                mostrarAlerta("Erro ao atualizar produto: " + e.getMessage());
            }
        } else {
            mostrarAlerta("Selecione um produto para atualizar!");
        }
    }


    private void preencherProdutoDoForm(Produto produto) {
        produto.setNome(txtNome.getText());
        produto.setDescricao(txtDescricao.getText());
        produto.setPreco(Double.parseDouble(txtPreco.getText()));
        produto.setEstoque(Integer.parseInt(txtEstoque.getText()));
        produto.setCategoriaId(cbCategoria.getValue().getId());
    }

    @FXML
    private void handleExcluir() {
        Produto produtoSelecionado = tableView.getSelectionModel().getSelectedItem();
        if (produtoSelecionado != null) {
            try {
                produtoDAO.delete(produtoSelecionado.getId());
                carregarProdutos();
                limparCampos();
                mostrarAlerta("Produto excluído com sucesso!", Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                mostrarAlerta("Erro ao excluir produto: " + e.getMessage());
            }
        } else {
            mostrarAlerta("Selecione um produto para excluir!");
        }
    }

    @FXML
    private void handleLimpar() {
        limparCampos();
        tableView.getSelectionModel().clearSelection();
    }

    private void limparCampos() {
        txtNome.clear();
        txtDescricao.clear();
        txtPreco.clear();
        txtEstoque.clear();
        cbCategoria.setValue(null);
    }

    private boolean validarCampos() {
        if (txtNome.getText().isEmpty() || txtPreco.getText().isEmpty() ||
                txtEstoque.getText().isEmpty() || cbCategoria.getValue() == null) {
            mostrarAlerta("Todos os campos (Nome, Preço, Estoque, Categoria) são obrigatórios!");
            return false;
        }
        try {
            Double.parseDouble(txtPreco.getText());
            Integer.parseInt(txtEstoque.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Preço deve ser um número (ex: 10.99) e Estoque deve ser um número inteiro!");
            return false;
        }
        return true;
    }


    private void mostrarAlerta(String mensagem) {
        mostrarAlerta(mensagem, Alert.AlertType.ERROR);
    }

    private void mostrarAlerta(String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
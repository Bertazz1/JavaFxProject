package controller;

import dao.VendaDAO;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import model.Venda;
import model.Cliente;
import model.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import java.time.LocalDate;

public class VendasController {

    // --- Componentes FXML ---
    @FXML private TableView<Venda> tableView;
    @FXML private TableColumn<Venda, Integer> colId;
    @FXML private TableColumn<Venda, LocalDate> colData;
    @FXML private TableColumn<Venda, String> colCliente;
    @FXML private TableColumn<Venda, String> colProduto;
    @FXML private TableColumn<Venda, Integer> colQtd;
    @FXML private TableColumn<Venda, Double> colTotal;

    @FXML private DatePicker dpData;
    @FXML private ComboBox<Cliente> cbCliente;
    @FXML private ComboBox<Produto> cbProduto;
    @FXML private TextField txtQuantidade;
    @FXML private TextField txtValorTotal; // Pode ser calculado ou manual

    // --- Atributos de dados ---
    private ObservableList<Venda> vendasList;
    private ObservableList<Cliente> clientesList;
    private ObservableList<Produto> produtosList;

    private VendaDAO vendaDAO;
    private ClienteDAO clienteDAO;
    private ProdutoDAO produtoDAO;

    @FXML
    public void initialize() {
        vendaDAO = new VendaDAO();
        clienteDAO = new ClienteDAO();
        produtoDAO = new ProdutoDAO();

        vendasList = FXCollections.observableArrayList();
        clientesList = FXCollections.observableArrayList();
        produtosList = FXCollections.observableArrayList();

        tableView.setItems(vendasList);
        cbCliente.setItems(clientesList);
        cbProduto.setItems(produtosList);

        configurarComboBoxes();

        txtQuantidade.textProperty().addListener((o, oldVal, newVal) -> calcularTotal());
        cbProduto.valueProperty().addListener((o, oldVal, newVal) -> calcularTotal());

        carregarClientes();
        carregarProdutos();
        carregarVendas();

        dpData.setValue(LocalDate.now()); // Padrão para data de hoje

        tableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarVenda(newValue));
    }


    private void carregarVendas() {
        try {
            vendasList.clear();
            vendasList.addAll(vendaDAO.read()); // DAO já faz a JOIN
        } catch (Exception e) {
            mostrarAlerta("Erro ao carregar vendas: " + e.getMessage());
        }
    }


    private void carregarClientes() {
        try {
            clientesList.clear();
            clientesList.addAll(clienteDAO.read());
        } catch (Exception e) {
            mostrarAlerta("Erro ao carregar clientes: " + e.getMessage());
        }
    }


    private void carregarProdutos() {
        try {
            produtosList.clear();
            produtosList.addAll(produtoDAO.read());
        } catch (Exception e) {
            mostrarAlerta("Erro ao carregar produtos: " + e.getMessage());
        }
    }


    private void configurarComboBoxes() {
        cbCliente.setConverter(new StringConverter<Cliente>() {
            @Override
            public String toString(Cliente cliente) {
                return cliente == null ? null : cliente.getNome();
            }
            @Override
            public Cliente fromString(String string) { return null; }
        });

        cbProduto.setConverter(new StringConverter<Produto>() {
            @Override
            public String toString(Produto produto) {
                // Usa o toString() do Produto.java
                return produto == null ? null : produto.toString();
            }
            @Override
            public Produto fromString(String string) { return null; }
        });
    }


    private void calcularTotal() {
        Produto produto = cbProduto.getValue();
        if (produto != null && !txtQuantidade.getText().isEmpty()) {
            try {
                int qtd = Integer.parseInt(txtQuantidade.getText());
                double total = produto.getPreco() * qtd;
                txtValorTotal.setText(String.format("%.2f", total));
            } catch (NumberFormatException e) {
                txtValorTotal.clear();
            }
        } else {
            txtValorTotal.clear();
        }
    }


    private void selecionarVenda(Venda venda) {
        if (venda != null) {
            dpData.setValue(venda.getDataVenda());
            txtQuantidade.setText(String.valueOf(venda.getQuantidade()));
            txtValorTotal.setText(String.valueOf(venda.getValorTotal()));

            for (Cliente c : cbCliente.getItems()) {
                if (c.getId() == venda.getClienteId()) {
                    cbCliente.setValue(c);
                    break;
                }
            }
            for (Produto p : cbProduto.getItems()) {
                if (p.getId() == venda.getProdutoId()) {
                    cbProduto.setValue(p);
                    break;
                }
            }
        }
    }

    @FXML
    private void handleSalvar() {
        if (validarCampos()) {
            try {
                Venda venda = new Venda();
                preencherVendaDoForm(venda);

                vendaDAO.create(venda);
                carregarVendas();
                limparCampos();
                mostrarAlerta("Venda salva com sucesso!", Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                mostrarAlerta("Erro ao salvar venda: " + e.getMessage());
            }
        }
    }

    @FXML
    private void handleAtualizar() {
        Venda vendaSelecionada = tableView.getSelectionModel().getSelectedItem();
        if (vendaSelecionada != null && validarCampos()) {
            try {
                preencherVendaDoForm(vendaSelecionada);

                vendaDAO.update(vendaSelecionada);
                carregarVendas();
                limparCampos();
                mostrarAlerta("Venda atualizada com sucesso!", Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                mostrarAlerta("Erro ao atualizar venda: " + e.getMessage());
            }
        } else {
            mostrarAlerta("Selecione uma venda para atualizar!");
        }
    }

    @FXML
    private void handleExcluir() {
        Venda vendaSelecionada = tableView.getSelectionModel().getSelectedItem();
        if (vendaSelecionada != null) {
            try {
                vendaDAO.delete(vendaSelecionada.getId());
                carregarVendas();
                limparCampos();
                mostrarAlerta("Venda excluída com sucesso!", Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                mostrarAlerta("Erro ao excluir venda: " + e.getMessage());
            }
        } else {
            mostrarAlerta("Selecione uma venda para excluir!");
        }
    }


    private void preencherVendaDoForm(Venda venda) {
        venda.setDataVenda(dpData.getValue());
        venda.setClienteId(cbCliente.getValue().getId());
        venda.setProdutoId(cbProduto.getValue().getId());
        venda.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
        venda.setValorTotal(Double.parseDouble(txtValorTotal.getText().replace(",", ".")));
    }

    @FXML
    private void handleLimpar() {
        limparCampos();
        tableView.getSelectionModel().clearSelection();
    }

    private void limparCampos() {
        dpData.setValue(LocalDate.now());
        cbCliente.setValue(null);
        cbProduto.setValue(null);
        txtQuantidade.clear();
        txtValorTotal.clear();
    }

    private boolean validarCampos() {
        if (dpData.getValue() == null || cbCliente.getValue() == null ||
                cbProduto.getValue() == null || txtQuantidade.getText().isEmpty()) {
            mostrarAlerta("Data, Cliente, Produto e Quantidade são obrigatórios!");
            return false;
        }
        try {
            Integer.parseInt(txtQuantidade.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Quantidade deve ser um número inteiro!");
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
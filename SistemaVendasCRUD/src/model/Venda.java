package model;

import java.time.LocalDate;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Venda {
    private final IntegerProperty id;
    private final ObjectProperty<LocalDate> dataVenda;
    private final IntegerProperty clienteId;
    private final StringProperty clienteNome;
    private final IntegerProperty produtoId;
    private final StringProperty produtoNome;
    private final IntegerProperty quantidade;
    private final DoubleProperty valorTotal;

    public Venda() {
        this.id = new SimpleIntegerProperty();
        this.dataVenda = new SimpleObjectProperty<>();
        this.clienteId = new SimpleIntegerProperty();
        this.clienteNome = new SimpleStringProperty();
        this.produtoId = new SimpleIntegerProperty();
        this.produtoNome = new SimpleStringProperty();
        this.quantidade = new SimpleIntegerProperty();
        this.valorTotal = new SimpleDoubleProperty();
    }
    
    public int getId() { return id.get(); }
    public void setId(int id) { this.id.set(id); }
    public IntegerProperty idProperty() { return id; }

    public LocalDate getDataVenda() { return dataVenda.get(); }
    public void setDataVenda(LocalDate dataVenda) { this.dataVenda.set(dataVenda); }
    public ObjectProperty<LocalDate> dataVendaProperty() { return dataVenda; }

    public int getClienteId() { return clienteId.get(); }
    public void setClienteId(int clienteId) { this.clienteId.set(clienteId); }
    public IntegerProperty clienteIdProperty() { return clienteId; }

    public String getClienteNome() { return clienteNome.get(); }
    public void setClienteNome(String clienteNome) { this.clienteNome.set(clienteNome); }
    public StringProperty clienteNomeProperty() { return clienteNome; }

    public int getProdutoId() { return produtoId.get(); }
    public void setProdutoId(int produtoId) { this.produtoId.set(produtoId); }
    public IntegerProperty produtoIdProperty() { return produtoId; }

    public String getProdutoNome() { return produtoNome.get(); }
    public void setProdutoNome(String produtoNome) { this.produtoNome.set(produtoNome); }
    public StringProperty produtoNomeProperty() { return produtoNome; }

    public int getQuantidade() { return quantidade.get(); }
    public void setQuantidade(int quantidade) { this.quantidade.set(quantidade); }
    public IntegerProperty quantidadeProperty() { return quantidade; }

    public double getValorTotal() { return valorTotal.get(); }
    public void setValorTotal(double valorTotal) { this.valorTotal.set(valorTotal); }
    public DoubleProperty valorTotalProperty() { return valorTotal; }
}
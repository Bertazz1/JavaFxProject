package controller;

import dao.VendaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;

import java.util.Map;

public class GraficoController {


    @FXML private BarChart<String, Number> barChart;
    @FXML private CategoryAxis xAxis;
    @FXML private NumberAxis yAxis;

    private VendaDAO vendaDAO;

    @FXML
    public void initialize() {
        vendaDAO = new VendaDAO();

        xAxis.setLabel("Mês (Ano-Mês)");
        yAxis.setLabel("Total de Vendas (R$)");

        carregarDadosGrafico();
    }


    private void carregarDadosGrafico() {
        try {
            Map<String, Double> vendasMensais = vendaDAO.getVendasMensais();

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName("Vendas Mensais");

            for (Map.Entry<String, Double> entry : vendasMensais.entrySet()) {
                series.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
            }

            barChart.setData(FXCollections.observableArrayList(series));

        } catch (Exception e) {
            mostrarAlerta("Erro ao carregar dados do gráfico: " + e.getMessage());
        }
    }

    private void mostrarAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
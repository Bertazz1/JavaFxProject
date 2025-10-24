// /src/application/AlertExemplo.java
package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlertExemplo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Botões para demonstrar diferentes tipos de Alert
        Button btnInfo = new Button("Mostrar Informação");
        btnInfo.setOnAction(e -> showAlert(AlertType.INFORMATION, "Informação", "Esse é um alerta de informação."));

        Button btnWarn = new Button("Mostrar Aviso");
        btnWarn.setOnAction(e -> showAlert(AlertType.WARNING, "Aviso", "Esse é um alerta de aviso."));

        Button btnError = new Button("Mostrar Erro");
        btnError.setOnAction(e -> showAlert(AlertType.ERROR, "Erro", "Esse é um alerta de erro."));
        
        Button btnConfirmation = new Button("Mostrar Confirmação");
        btnConfirmation.setOnAction(e -> showAlert(AlertType.CONFIRMATION, "Confirmação", "Esse é um alerta de confirmação."));

        VBox vbox = new VBox(10);
       
        vbox.getChildren().addAll(btnInfo, btnWarn, btnError, btnConfirmation);
        
        
        Scene scene = new Scene(vbox, 500, 500);
        
        
        primaryStage.setTitle("Exemplo de Alert");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método utilitário para exibir Alert
    private void showAlert(AlertType alertType, String title, String msg) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

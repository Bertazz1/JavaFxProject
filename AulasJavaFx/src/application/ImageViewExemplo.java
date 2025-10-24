// /src/application/AlertExemplo.java
package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ImageViewExemplo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Image img = new Image("file:/Users/nelsonbellincanta/eclipse-workspace/AulasJavaFx/src/application/grogu.jpg");
        
        ImageView imgView = new ImageView(img);
        
        imgView.setFitWidth(200);
        imgView.setFitHeight(300);
        imgView.setPreserveRatio(true);

        VBox vbox = new VBox(10);
       
        vbox.getChildren().addAll(imgView);
        
        
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

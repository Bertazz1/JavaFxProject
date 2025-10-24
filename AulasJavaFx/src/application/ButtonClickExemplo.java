package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ButtonClickExemplo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
               	
        	//Label
        	Label lblBtn01 = new Label("Clique no botão para ver o resultado.");
        	
        	//Button
        	Button btn01 = new Button("Clique aqui!");
        	
        	//Criando evento
        	btn01.setOnAction(event -> {
        		lblBtn01.setText("Você clicou no botão!");
        	});
        	
        	//Layout 
        	VBox vBox = new VBox();
        	vBox.getChildren().addAll(lblBtn01, btn01);
        	
        	
            //Scene
            Scene scene = new Scene(vBox, 400, 400);
            
            //PrimaryStage
            primaryStage.setScene(scene);
            primaryStage.setTitle("BorderPane Exemplo");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
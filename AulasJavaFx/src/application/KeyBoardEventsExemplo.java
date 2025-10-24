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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class KeyBoardEventsExemplo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
               	
        	//Label
        	Label lblBtn01 = new Label("Interaja com seu teclado.");
        	
        	//Layout
        	StackPane root = new StackPane();
        	
        	root.getChildren().add(lblBtn01);
        	
        	//Capturar eventos de teclado
        	root.setOnKeyPressed(event -> {
        		
        		String key = event.getCode().toString();
        		
        		lblBtn01.setText("Tecla pressionada: " + key);
        	});
        	
        	
        	//Eento de mouse
        	root.setOnMouseClicked(event -> {
        		double x = event.getSceneX();
        		double y = event.getSceneY();
        		
        		lblBtn01.setText("Mouse clicado em X: " + x + " e Y: " + y);
        	});
        	
            //Scene
            Scene scene = new Scene(root, 400, 400);
            
            scene.setOnKeyPressed(root.getOnKeyPressed());
            
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
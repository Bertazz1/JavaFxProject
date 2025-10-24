package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonLabelExemplo extends Application{
	 @Override
	    public void start(Stage primaryStage) {
	        try {
	          
	        	Label label = new Label("Este é um label");
	        	
	        	Button btn = new Button("Clique aqui!");
	        	
	        	btn.setOnAction(event -> label.setText("Você clicou no botão!"));
	        	
	        	//Criando uma cena com layout
	        	VBox vbox = new VBox();
	        	vbox.getChildren().addAll(label, btn);
	        	
	            //Criando uma cena com o layout  
	            Scene scene = new Scene(vbox, 500, 500);
	            
	            // Corrigido: usando this.getClass() para referenciar a classe atual
	            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	            
	            //Confirguração do Stage
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

	
	


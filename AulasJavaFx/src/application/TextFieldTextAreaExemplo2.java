package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFieldTextAreaExemplo2 extends Application{
	 @Override
	    public void start(Stage primaryStage) {
	        try {
	          
	        	TextField textField = new TextField();
	        	textField.setPromptText("Digite o seu nome: ");
	        	
	        	TextField textField2 = new TextField();
	        	textField2.setPromptText("Digite sua idade: ");
	        	
	        	//limitar caracteres
	        	textField2.textProperty().addListener((observable, oldValue, newValue) -> {
	        		if(newValue.length() > 3) {
	        			textField2.setText(oldValue);
	        		}
	        	});
	        	
	        	//TextArea
	        	TextArea textArea = new TextArea();
	        	textArea.setPromptText("Escreva o seu texto aqui...");
	        	textArea.setPrefRowCount(5);
	        	
	        	Label label = new Label("Texto do TextArea: ");
	        	
	        	textArea.textProperty().addListener((observable, oldValue, newValue) -> {
	        		label.setText("Texto do textArea: " + newValue);
	        	});
	        	
	        	
	        	//Criando uma cena com layout
	        	VBox vbox = new VBox();
	        	vbox.getChildren().addAll(textField, textField2, textArea, label);
	        	
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

	
	


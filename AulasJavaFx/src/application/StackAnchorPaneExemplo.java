package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StackAnchorPaneExemplo extends Application{
	 @Override
	    public void start(Stage primaryStage) {
	        try {
	            // Criar botões
	            Button btn1 = new Button("Botão 01");
	            Button btn2 = new Button("Botão 02");
	            Button btn3 = new Button("Botão 03");
	            Button btn4 = new Button("Botão 04");
	            Button btn5 = new Button("Botão 05");
	            Button btn6 = new Button("Botão 06");
	            
	            //Criar StackPane
	            
	            StackPane stackPane = new StackPane();
	            
	            stackPane.getChildren().addAll(btn1, btn2);
	            
	            Scene stackScene = new Scene(stackPane, 400, 400);
	            
	            //Criar o AnchorPane
	            
	            AnchorPane anchorPane = new AnchorPane();
	            
	            anchorPane.setTopAnchor(btn3, 10.0);
	            anchorPane.setRightAnchor(btn3, 10.0);
	            
	            anchorPane.getChildren().add(btn3);
	            
	            Scene anchorScene = new Scene(anchorPane, 400, 400);
	            
	            // Corrigido: usando this.getClass() para referenciar a classe atual
	            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	            
	            //Confirguração do Stage
	            primaryStage.setScene(stackScene);
	            primaryStage.setTitle("BorderPane Exemplo");
	            primaryStage.show();
	            
	            //Mudar a cena depois de 2 segundos 
	            new Thread(() -> {
	            	try { 
	            		Thread.sleep(2000);
	            	
	            		Platform.runLater(() -> primaryStage.setScene(anchorScene));
	            	} catch (Exception e) {
	            		
	            	}
	            		
	            }).start();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public static void main(String[] args) {
	        launch(args);
	    }
	}

	
	


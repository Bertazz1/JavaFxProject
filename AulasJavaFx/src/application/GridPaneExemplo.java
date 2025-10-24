package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneExemplo extends Application{
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
	            
	            //Criar Grid Pane
	            
	            GridPane gridPane = new GridPane();
	            
	            gridPane.add(btn1, 2, 3);
	            gridPane.add(btn2, 0, 0);
	            gridPane.add(btn3, 1, 1);
	            gridPane.add(btn4, 2, 1);
	            gridPane.add(btn5, 2, 2);
	            
	            //cria espaçamento entre as colunas (horizontal/vertical)
	            gridPane.setHgap(10);
	            gridPane.setVgap(20);
	            
	            //Criando uma cena com o layout  
	            Scene scene = new Scene(gridPane, 500, 500);
	            
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

	
	


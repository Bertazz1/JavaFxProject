package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CSSStylesExemplo extends  Application{
	 @Override
	    public void start(Stage primaryStage) {
	        try {
	               	
	        	//Label
	        	Label lblStyle = new Label("Label estilizada!");
	        	
	        	lblStyle.getStyleClass().add("label-custom");
	        	
	        	Button  btn01 = new Button("Botão estilizado!");
	        	
	        	btn01.getStyleClass().add("button-custom");
	        	
	        	//Layout
	        	VBox vbox = new VBox(10);
	        	
	        	vbox.getChildren().addAll(lblStyle, btn01);
	        	
	        
	            //Scene
	            Scene scene = new Scene(vbox, 400, 400);
	            
	            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	           
	            
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

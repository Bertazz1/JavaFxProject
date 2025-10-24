package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SecondaryWindowExemplo extends  Application{
	 @Override
	    public void start(Stage primaryStage) {
	        try {
	        	
	        	Button  btn01 = new Button("Abrir janela secundária!");
	        	
	        	btn01.setOnAction(event -> openSecondaryWindow());
	        	
	        	//Layout
	        	StackPane primaryLayout = new StackPane();
	        	
	        	primaryLayout.getChildren().addAll(btn01);
	        	
	        
	            //Scene
	            Scene primaryScene = new Scene(primaryLayout, 400, 400);
	           
	            
	            //PrimaryStage
	            primaryStage.setScene(primaryScene);
	            primaryStage.setTitle("Primary Scene");
	            primaryStage.show();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 	public void openSecondaryWindow() {
	 		
	 		Stage secondaryStage = new Stage();
	 		
	 		Label lbl01 = new Label("Janela secundária");
	 		
	 		StackPane secondaryLayout = new StackPane();
	 		
	 		secondaryLayout.getChildren().add(lbl01);
	 		
	 		Scene secondaryScene = new Scene(secondaryLayout, 400, 400);
	 		
	 		secondaryStage.setScene(secondaryScene);
	 		secondaryStage.setTitle("Janela Secundária");
	 		secondaryStage.show();
	 	}
	    
	    public static void main(String[] args) {
	        launch(args);
	    }

}

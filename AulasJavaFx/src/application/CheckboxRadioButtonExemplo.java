package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckboxRadioButtonExemplo extends Application{
	 @Override
	    public void start(Stage primaryStage) {
	        try {
	          
	        	//Criando checkbox
	        	CheckBox chkBox1 = new CheckBox("Opção 1");
	        	CheckBox chkBox2 = new CheckBox("Opção 2");
	        	
	        	Label chkBoxLabel = new Label("Checbox selecionados: ");
	        	
	        	chkBox1.setOnAction(event -> updateCheckBoxLabel(chkBox1,chkBox2,chkBoxLabel ));
	        	chkBox2.setOnAction(event -> updateCheckBoxLabel(chkBox1,chkBox2,chkBoxLabel ));
	        	
	        	
	        	//Criando RadioButton
	        	RadioButton rBtn1 = new RadioButton("Opção A");
	        	RadioButton rBtn2 = new RadioButton("Opção B");
	        	
	        	Label rBtnLabel = new Label("Radio Button selecionados: ");
	        	
	        	ToggleGroup toggleGrp = new ToggleGroup();
	        	
	        	rBtn1.setToggleGroup(toggleGrp);
	        	rBtn2.setToggleGroup(toggleGrp);
	        	
	        	toggleGrp.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
	        		if(newValue != null) {
	        			RadioButton selectRdButton = (RadioButton) toggleGrp.getSelectedToggle();
	        			
	        			rBtnLabel.setText("Radio Button Selecionado: " + selectRdButton.getText());
	        		}
	        	});
	        	
	        	
	        	//Criando uma cena com layout
	        	VBox vbox = new VBox();
	        	vbox.getChildren().addAll(chkBoxLabel, chkBox1, chkBox2, rBtnLabel, rBtn1, rBtn2);
	        	
	            //Criando uma cena com o layout  
	            Scene scene = new Scene(vbox, 500, 500);
	            
	            // Corrigido: usando this.getClass() para referenciar a classe atual
	            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	            
	            //Confirguração do Stage
	            primaryStage.setScene(scene);
	            primaryStage.setTitle("Checkbox e RadioButton");
	            primaryStage.show();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	 
	 	public void updateCheckBoxLabel(CheckBox chBox1, CheckBox chBox2, Label label) {
	 		String selected = "Checkbox selecionados: ";
	 		if(chBox1.isSelected()) selected += chBox1.getText() + " ";
	 		if(chBox2.isSelected()) selected += chBox2.getText() + " ";
	 		
	 		label.setText(selected);
	 	}
	 
	    public static void main(String[] args) {
	        launch(args);
	    }
	}

	
	


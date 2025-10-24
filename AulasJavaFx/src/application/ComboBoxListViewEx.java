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

public class ComboBoxListViewEx extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            //ComboBox
        	ComboBox<String> cmbBox = new ComboBox<>();
        	
        	cmbBox.getItems().addAll("Opção 1", "Opção 2", "Opção 3");
        	
        	cmbBox.setPromptText("Selecione uma opção!");
        	
        	Label cmbBoxLbl = new Label("Seleção ComboBox: ");
        	
        	cmbBox.setOnAction(event -> {
        		String selecionado = cmbBox.getSelectionModel().getSelectedItem();
        		
        		cmbBoxLbl.setText("Seleção ComboBox: " + selecionado);
        	});
            
        	//ListWiew
        	ObservableList<String> items = FXCollections.observableArrayList("Item A", "Item B", "Item C", "Item D");
        	
        	ListView<String> listView = new ListView<>(items);
        	
        	listView.setPrefHeight(150);
        	
        	Label lstViewLbl = new Label("Seleção List View: ");
        	
        	listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {  
        		//String selecionado = cmbBox.getSelectionModel().getSelectedItem();
        		
        		cmbBoxLbl.setText("Seleção List View: " + newValue);
        	});
        	
        	//Habilitar mais itens
        	listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        	
        	//Layout 
        	VBox vBox = new VBox();
        	vBox.getChildren().addAll(cmbBox, cmbBoxLbl, listView);
        	
        	
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
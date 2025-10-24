package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class BorderPaneExemplo extends Application {
    
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
            
            // Criar BorderPane e adicionar botões
            BorderPane borderPane = new BorderPane();
            borderPane.setTop(btn1);
            borderPane.setBottom(btn2);
            borderPane.setLeft(btn3);
            borderPane.setRight(btn4);
            borderPane.setCenter(btn5);
            
            borderPane.setTop(btn6);
            
            Scene scene = new Scene(borderPane, 400, 400);
            
            // Corrigido: usando this.getClass() para referenciar a classe atual
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            
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
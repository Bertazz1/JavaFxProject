// /src/application/AlertExemplo.java
package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class ShapeDrawingExemplo extends Application {

    @Override
    public void start(Stage primaryStage) {
        
    	//retangulo
    	Rectangle retangulo = new Rectangle(200, 100);
    	
    	retangulo.setFill(Color.CHOCOLATE);
    	retangulo.setStroke(Color.AQUA);
    	retangulo.setStrokeWidth(4);
    	
    	//circulo
    	Circle circulo = new Circle(50);
    	
    	circulo.setFill(Color.DARKSALMON);
    	circulo.setStroke(Color.GOLD);
    	circulo.setStrokeWidth(20);
    	
    	//elipse
    	
    	Ellipse elipse = new Ellipse(50, 100);
    	
    	elipse.setFill(Color.SLATEGRAY);
    	
        VBox vbox = new VBox(10);
       
        vbox.getChildren().addAll(retangulo, circulo, elipse);
        
        
        Scene scene = new Scene(vbox, 500, 500);
        
        
        primaryStage.setTitle("Exemplo de Alert");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

// /src/application/AlertExemplo.java
package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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

public class CanvasExemplo extends Application {

    @Override
    public void start(Stage primaryStage) {
        
    	Canvas canvas = new Canvas(400, 400);
    	
    	GraphicsContext gc = canvas.getGraphicsContext2D();
    	
    	//desenhar o canvas
    	
    	drawShapes(gc);
    	
        VBox vbox = new VBox(10);
       
        vbox.getChildren().addAll(canvas);
        
        
        Scene scene = new Scene(vbox, 500, 500);
        
        
        primaryStage.setTitle("Exemplo de Alert");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void drawShapes(GraphicsContext gc) {
    	
    	gc.setStroke(Color.BLUE);
    	gc.setLineWidth(2);
    	
    	//gc.strokeLine(50, 20, 350, 120);
    	gc.strokeLine(50, 50, 350, 50);
    	
    	gc.setFill(Color.LIGHTBLUE);
    	gc.fillRect(100, 100, 250, 150);
    	
    	gc.setStroke(Color.RED);
    	//gc.strokeOval(150,  150, 100, 100);
    	gc.strokeOval(250,  250, 100, 100);
    	
    	
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

/**
 *
 * @author Troy Local
 */
public class CH14GUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        FlowPane pane = new FlowPane();
        
        pane.setPadding(new Insets(10,10,10,10));
        pane.setHgap(10000);
        
        Image image = new Image("resource/knuckles.png");
        
        ImageView imageview = new ImageView(image);
        TextField tf1 = new TextField();
        Button btn = new Button("Do u Kno da Wae?");
        tf1.setPrefColumnCount(17);
        
        imageview.setFitHeight(200);
        imageview.setFitWidth(200);
        pane.getChildren().addAll(new Label("Ugandan Knuckles"),imageview, tf1, btn);
        
        Scene scene = new Scene(pane, 230, 300);
        primaryStage.setTitle("CH 14 GUI"); 
        primaryStage.setScene(scene);       //Place Scene in stage
        primaryStage.show();                //Display Stage
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

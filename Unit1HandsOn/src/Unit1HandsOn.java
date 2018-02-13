
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;

/**
 *  author Troy Wingo
 */
public class Unit1HandsOn extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //Circle Head
        Circle head = new Circle();
        head.setCenterX(250);
        head.setCenterY(175);
        head.setRadius(50);
        head.setStroke(Color.BLACK);
        head.setFill(Color.WHITE);
        
        //Base Arc
        Arc base = new Arc();
        base.setCenterX(125);
        base.setCenterY(500);
        base.setRadiusX(50);
        base.setRadiusY(25);
        base.setStartAngle(360);
        base.setLength(180);
        base.setStroke(Color.BLACK);
        base.setFill(Color.WHITE);
        
        //Lines
        Line line1 = new Line(250, 125, 250, 75);
        Line line2 = new Line(250, 75, 125, 75);
        Line line3 = new Line(125, 75, 125, 500);
        Line line4 = new Line(250, 225, 250, 350);
        Line line5 = new Line(250, 350, 275, 450);
        Line line6 = new Line(250, 350, 225, 450);
        Line line7 = new Line(250, 250, 300, 350);
        Line line8 = new Line(250, 250, 200, 350);
        
        //Main Pane
        Pane pane = new Pane();
        pane.getChildren().addAll(
                head, 
                line1, 
                line2, 
                line3, 
                line4, 
                line5, 
                line6, 
                line7, 
                line8,
                base);
        
        //Main Scene
        Scene scene = new Scene(pane, 500, 600);
        
        //Head Window Binding
        //head.centerXProperty().bind(pane.widthProperty().divide(2));
        //head.centerYProperty().bind(pane.widthProperty().divide(3));
        
        //Scene Set
        primaryStage.setTitle("Uniit 1 Hands-On");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

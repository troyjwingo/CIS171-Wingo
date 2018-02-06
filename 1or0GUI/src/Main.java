import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Troy Local
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        
        for(int i = 0; i < 10; i++){
                for(int x = 0; x < 10; x++){

                    Random rand = new Random();
                    int rando = rand.nextInt(2);
                    String randoString = Integer.toString(rando);
                    // Iterate Text-Field
                    TextField tf1 = new TextField();
                    tf1.setPrefColumnCount(1);
                    tf1.setEditable(false);
                    tf1.setText(randoString);
                    // Change column index based on loop
                    pane.setRowIndex(tf1,i);
                    pane.setColumnIndex(tf1,x);    
                    pane.getChildren().add(tf1);
                }
            }
        
        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("0 or 1");
        primaryStage.setScene(scene);
        primaryStage.show();
                
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}

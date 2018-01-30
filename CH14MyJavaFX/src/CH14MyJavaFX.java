
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CH14MyJavaFX extends Application{
    @Override  //Override the start method in application class
    public void start(Stage primaryStage){
        //Create button and place in scene
        Button btOK = new Button("THE BIG BUTTON");
        //btOK.setMaxSize(25, 50);
        Scene scene = new Scene(btOK, 200, 250);
        
        primaryStage.setTitle("MyJavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}

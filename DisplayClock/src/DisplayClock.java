import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DisplayClock extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ClockPane clockPane = new ClockPane();
        clockPane.start();
        
        //Stop Start Buttons
        Button start = new Button("Start");
        start.setOnAction(e -> clockPane.start());
        Button stop = new Button("Stop");
        stop.setOnAction(e -> clockPane.stop());

        //Adds Buttons
        HBox hBox = new HBox(start, stop);
        hBox.setAlignment(Pos.CENTER);
        BorderPane pane = new BorderPane(clockPane, null, null, hBox, null);

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Clock");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}


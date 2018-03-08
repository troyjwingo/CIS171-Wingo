import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exam2HandsOn extends Application {
    
    //Initialization of Input (tUsDollars) and Output (tCaDollars) TextFields
    TextField tUsDollars = new TextField();
    TextField tCaDollars = new TextField();

    @Override
    public void start(Stage primaryStage) {
        
        //Event Handler
        EventHandler<ActionEvent> handler = event -> UpdateField();
        tUsDollars.setOnAction(handler);
        
        //Property Adjustments for Text in US and CA Textfields
        tUsDollars.setAlignment(Pos.CENTER);
        tCaDollars.setAlignment(Pos.CENTER);
        tCaDollars.setEditable(false);
        
        //Label and Label Placement for US TextField
        Label lUsDollarAm = new Label("Dollars in US:", tUsDollars);
        lUsDollarAm.setContentDisplay(ContentDisplay.RIGHT);
        
        //Label and Label Placement for CA TextField
        Label lCaDollarAm = new Label("Dollars in CA:", tCaDollars);
        lCaDollarAm.setContentDisplay(ContentDisplay.RIGHT);
        
        //Covert Button and Event Handling
        Button btConvert = new Button("Convert");
        btConvert.setOnAction(handler);
        
        //VBox for Textfields, Labels, and Convert Button
        VBox inputPane = new VBox();
        inputPane.getChildren().addAll(lUsDollarAm, tUsDollars, lCaDollarAm, tCaDollars, btConvert);
        
        //Border Pane to Store VBox: inputPane
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(inputPane);
        
        //Scene Initialization and Stage Initialization
        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("Exam 2 Hands-On");
        primaryStage.show();
    }

    public void UpdateField() {
        //Gets Text From Input TextField (tUsDollars)
        double UsDollarAmount = Double.parseDouble(tUsDollars.getText());

        //Coversion Rate
        double CanadaConvert = UsDollarAmount * 1.5;

        //Formating For Canadian Dollar TextField (tCaDollars)    
        String s = String.format("%.2f", CanadaConvert);
        tCaDollars.setText(s);

            
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
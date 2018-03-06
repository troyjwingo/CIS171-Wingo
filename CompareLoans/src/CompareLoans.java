import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CompareLoans extends Application {

    TextField tLoanAmount = new TextField();
    TextField tNumYears = new TextField();
    TextArea tTextArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        
        EventHandler<ActionEvent> handler = event -> Update();
        tNumYears.setOnAction(handler);
        tLoanAmount.setOnAction(handler);
        
        //Label and Label Placement for tLoanAmount Textfield
        Label lLoanAmount = new Label("Enter Loan Amount:", tLoanAmount);
        lLoanAmount.setContentDisplay(ContentDisplay.RIGHT);
        
        //Label and Label Placement for tNumYears TextField
        Label lNumOfYears = new Label("Enter Number Of Years:", tNumYears);
        lNumOfYears.setContentDisplay(ContentDisplay.RIGHT);

        HBox inputPane = new HBox();
        Button btShowTable = new Button("Show Table");
        btShowTable.setOnAction(handler);
        inputPane.getChildren().addAll(lLoanAmount, lNumOfYears, btShowTable);

        BorderPane borderPane = new BorderPane(tTextArea);
        borderPane.setTop(inputPane);

        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("");
        primaryStage.show();
    }

    public void Update() {
        double annInterestRate = 5.00;
        double loanAmount = Double.parseDouble(tLoanAmount.getText());
        double numYears = Double.parseDouble(tNumYears.getText());

        String s = String.format("%-1s%20s%20s\n", "Interest Rate", "Monthly Payment", "Total Payment");

        for ( ; annInterestRate <= 8.00; annInterestRate += 0.125) {

            //Monthly and Total Pay Rates
            double monthlyInterestRate = annInterestRate / 1200;
            double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, numYears * 12));
            double totalPayment = monthlyPayment * numYears * 12;

            //Formating for Text Output In tTextArea
            String percent = "%";
            String dollar = "$";
            
            s += String.format("%-1.3f%s%19.2f%30.2f \n", annInterestRate, percent, ((int) (monthlyPayment * 100) / 100.0), ((int) (totalPayment * 100) / 100.0));
            tTextArea.setText(s);
        }

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch24ex24_07;

import java.util.LinkedList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author rileyre
 */
public class Exercise24_07 extends Application {
    // class level variables
    protected static LinkedList<Integer> list = new LinkedList<>();
    private LinkedListView view = new LinkedListView();
    private Button btSearch = new Button("Search");
    private Button btInsert = new Button("Insert");
    private Button btDelete = new Button("Delete");
    private TextField tfNumber = new TextField();
    private TextField tfIndex = new TextField();
    
    @Override
    public void start(Stage primaryStage) {
        HBox hbox = new HBox(5);
        hbox.getChildren().addAll(new Label("enter a value: "), tfNumber, new Label("enter an index"), tfIndex, btSearch, btInsert, btDelete);
        hbox.setAlignment(Pos.CENTER);
        
        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(view);
        borderpane.setBottom(hbox);
        
        Label lblStatus = new Label();
        borderpane.setTop(lblStatus);
        borderpane.setAlignment(lblStatus, Pos.CENTER);
        
        //create scene
        Scene scene = new Scene(borderpane, 500, 250);
        primaryStage.setTitle("Exercise24_07");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        view.repaint();
        tfNumber.setPrefColumnCount(2);
        tfIndex.setPrefColumnCount(2);
        
        btSearch.setOnAction(e -> {
        lblStatus.setText("");
        if (!list.contains(Integer.parseInt(tfNumber.getText()))) {
            lblStatus.setText("key is not on the list");
        }
        else {
            lblStatus.setText("key is in the list");
        }
        view.repaint();
        });
        
        btInsert.setOnAction(e -> {
        lblStatus.setText("");
        if (tfIndex.getText().trim().length() > 0) {
            list.add(Integer.parseInt(tfIndex.getText()), Integer.parseInt(tfNumber.getText()));
        }
        else {
            list.add(Integer.parseInt(tfNumber.getText()));
        }
        view.repaint();
        });
        
        btDelete.setOnAction(e -> {
        lblStatus.setText("");
        if (tfIndex.getText().trim().length() > 0) {
            list.add(Integer.parseInt(tfIndex.getText()), Integer.parseInt(tfNumber.getText()));
        }
        else {
            lblStatus.setText("key is deleted from list");
            list.remove(new Integer(Integer.parseInt(tfNumber.getText())));
            view.repaint();
        }
        });
        
    }
    
    public LinkedList<Integer> get_List(){
        return list;
    }
    
    public void set_List(LinkedList<Integer>theList){
        this.list = theList;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rileyre
 */
class LinkedListView extends Pane {
    private int startingX = 20;
    private int startingY = 20;
    private int boxWidth = 50;
    private int boxHeight = 20;
    private int arrowLineLength = 30;
    private int hGap = 80;
    
    

    protected void repaint() {
        getChildren().clear();
        
        if (Exercise24_07.list.size() == 0) {             // empty list - load head and tail
            getChildren().add(new Text(startingX, startingY, "head: null"));
            getChildren().add(new Text(startingX, startingY + 15, "tail: null"));
        } // end of if
        else {
            getChildren().add(new Text(startingX, startingY, "head"));
            
            int x = startingX + 30;
            int y = startingY + 20;
            
            drawArrowLine(startingX + 5, startingY,  x,  y);
            
            for (int i = 0; i < Exercise24_07.list.size(); i++) {
                Rectangle rectangle = new Rectangle(x, y, boxWidth, boxHeight);
                rectangle.setFill(Color.ALICEBLUE);
                rectangle.setStroke(Color.BLANCHEDALMOND);
                getChildren().add(rectangle);
                
                getChildren().add(new Line(x + arrowLineLength, y, x + arrowLineLength, y + boxHeight));
                
                if (i < Exercise24_07.list.size() -1) {
                    drawArrowLine(x + 40, y + boxHeight / 2, x + hGap, y + boxHeight / 2);
                } // end of if
                
                getChildren().add(new Text(x + 10, y + 15, Exercise24_07.list.get(i) + ""));
                
                x = x + hGap;
            } // end of for
            
            getChildren().add(new Text(x, startingY, "tail"));
            drawArrowLine(x, startingY, x - hGap, y);
        } // end of else
    } // end of repaint
    
    public void drawArrowLine(double x1, double y1, double x2, double y2) {
        getChildren().add(new Line(x1, y1, x2, y2));
        
        // find slope of the line
        double slope = ((((double) y1) - (double) y2))
                / (((double) x1) - (((double) x2)));
        
        double arctan = Math.atan(slope);
        
        // this will flip the arrow 45 off of a 
        // perpendicular line at pt x2
        double set45 = 1.57 / 2;
        
        // arrows should always point towards i, not i+1
        if (x1 < x2) {
            // add 90 degrees to arrow lines
            set45 = -1.57 * 1.5;
        }  // end of if
        
        // set length of arrows
        int arrlen = 15;
        
        getChildren().add(new Line( x2, 
                                                        y2, 
                                                        (x2 + (Math.cos(arctan + set45) * arrlen)), 
                                                        (y2) + (Math.sin(arctan + set45) * arrlen)));
        
        getChildren().add(new Line( x2, 
                                                        y2, 
                                                        (x2 + (Math.cos(arctan - set45) * arrlen)), 
                                                        (y2) + (Math.sin(arctan - set45) * arrlen)));
    } // end of drawArrowLine
} //end of class LinkedListView


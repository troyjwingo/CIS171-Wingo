

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RaceCarV2 extends Application {
    
    public void start(Stage primaryStage) {
        CarPane car = new CarPane(600, 200);
        
        //Sets Timeline to loop Animation
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(10), e-> car.move(1)));
        timeline.setCycleCount(car.getCycle());
        timeline.play();
        timeline.setOnFinished(e-> {
            car.reset();
            timeline.play();
        });
        
        Button pause = new Button("Pause");
        Button resume = new Button("Resume");
        Button increase = new Button("Increase");
        Button decrease = new Button("Decrease");
        
        HBox hbox = new HBox(pause,resume,increase,decrease);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        
        //hbox.setAlignment(Pos.CENTER);
        //hbox.getChildren().addAll(pause,resume,increase,decrease);
        
        BorderPane pane = new BorderPane(car, null, null, hbox, null);
        
        pane.setCenter(car);
        
        pause.setOnAction(e-> timeline.pause());
        resume.setOnAction(e-> timeline.play());
        increase.setOnAction(e-> {
            timeline.setRate(timeline.getCurrentRate() + 1);
        });
        
        Scene scene = new Scene(pane, 600, 300);
        
        primaryStage.setTitle("Race Car");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    
    public static void main(String[] args) {
        launch(args);
    }

private class CarPane extends Pane {
        //Class fields
        private double w;
        private double h;

        //Left Tire Start Points
        private double leftTireX; 
        private double leftTireY;
        private double tireRadius;

        Circle[] tires = new Circle[2];
        Polyline cover = new Polyline();
        ObservableList<Double> points;
        Rectangle body;

        private CarPane(double width, double height){

            //Tire Measurements
            w = width;
            h = height;
            leftTireX = w * 0.2;
            leftTireY = h * 0.9;
            tireRadius = h * 0.1;

            //Set MIN and MAX width
            setMinWidth(w);
            setMinHeight(h);

            setMaxWidth(w);
            setMaxHeight(h);

            reset();
        }

        public void reset() {
            //Resets Car to Starting Position
            if (points != null)
                points.clear();
            getChildren().clear();
            drawCar();
            move(tireRadius * 13 * -1);
        }

        public void drawCar() {
            //Draws Car Tires
            for (int i = 0; i < tires.length; i++) {
                tires[i] = new Circle(leftTireX + (i * 4 * tireRadius), leftTireY, tireRadius);
                tires[i].setStroke(Color.BLACK);
                tires[i].setFill(Color.BLACK);

            }
            double baseX = tires[0].getCenterX() - tires[0].getRadius() * 3;
            double baseY = tires[0].getCenterY() - tires[0].getRadius() * 3;
            body = new Rectangle(baseX, baseY, tireRadius * 10, tireRadius * 2);
            body.setFill(Color.YELLOW);
            body.setStroke(Color.BLACK);

            double startX = body.getX() + tireRadius * 2;
            double startY = body.getY();
            double curX = startX;
            double curY = startY;

            points = cover.getPoints();

            double distance = tireRadius * 2;
            points.addAll(curX, curY);

            curX += distance;
            curY -= distance;
            points.addAll(curX, curY);

            curX += distance;
            points.addAll(curX,curY);

            curX += distance;
            curY += distance;
            points.addAll(curX,curY); 

            points.addAll(startX, startY); 
            cover.setFill(Color.BLACK);

            getChildren().addAll(tires);
            getChildren().add(body);
            getChildren().add(cover);
        }

        private void move(double distance) {
            //Method That Moves Car
            for (Circle c : tires) {
                c.setCenterX(c.getCenterX() + distance);
            }
            body.setX(body.getX() + distance);
            for (int i = 0; i < points.size(); i += 2) {
                points.set(i, points.get(i) + distance);
            }

        }

        public int getCycle(){
            return (int)w;
        }
    }
}
package blackjack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.scene.layout.Pane;

public class BlackJackV2 extends Application {
    private final Deck deck = new Deck(1);  
    private final Hand hand = new Hand();  
    private final Hand cpu = new Hand();  
    
    private boolean busted; 
    private boolean playerTurn; 
    
    FlowPane cards = new FlowPane(Orientation.HORIZONTAL);
    FlowPane cpuCards = new FlowPane(Orientation.HORIZONTAL);
    
    Label tLbl = new Label();
    Label tLblCpu = new Label();
    Label cpuLbl = new Label("CPU Hand"); 
    Label playerLbl = new Label("Your Hand"); 
    Label status = new Label();
    
    public void drawCard(Hand hand, FlowPane pane, Label l){
        try{
            Card card = deck.dealCard(); 
            ImageView img = new ImageView(card.getCardImage()); 
            pane.getChildren().add(img); 
            hand.addCard(card); 
            
            int handTotal = hand.checkHand(); 
            
            StringBuilder total = new StringBuilder(); 
            if(hand.getSoft() > 0){
                total.append(handTotal-10).append("/");
            }
            total.append(handTotal); 
            l.setText(total.toString()); 
        } catch (Exception ex){
            System.out.println(ex.getMessage()); 
        }
    }
    
    public void newDeck(){
        deck.restoreDeck(); 
        deck.shuffle(); 
    }
    
    public void newHand(){
        // check if we should shuffle 
        if(deck.getNumberOfCardsRemaining() <= deck.getSizeOfDeck()*0.2){
            newDeck(); 
        }
        
        // clear everything 
        hand.discardHand(); 
        cpu.discardHand(); 
        cards.getChildren().removeAll(cards.getChildren());  
        cpuCards.getChildren().removeAll(cpuCards.getChildren()); 
        tLbl.setText(""); 
        tLblCpu.setText(""); 
        
        busted = false; 
        playerTurn = true; 
        
        drawCard(hand, cards, tLbl); 
        drawCard(cpu, cpuCards, tLblCpu); 
        drawCard(hand, cards, tLbl); 
        
        status.setText("Your turn"); 
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        Button drawbtn = new Button();
        drawbtn.setText("Hit");
        drawbtn.setOnAction((e) -> {
            if(playerTurn == true && busted != true){
                drawCard(hand, cards, tLbl); 

                if(hand.checkHand() > 21){
                    // you busted 
                    System.out.println("You've been busted"); 
                    busted = true; 
                    playerTurn = false; 
                    status.setText("You've been busted"); 
                }
            }
        });
        
        Button standbtn = new Button();
        standbtn.setText("Stay");
        standbtn.setOnAction((e) -> {
            if(playerTurn == true && busted != true){
                playerTurn = false; 
                while(cpu.checkHand() < 17){
                    drawCard(cpu, cpuCards, tLblCpu);
                } 
                
                int playerTotal = hand.checkHand(); 
                int cpuTotal = cpu.checkHand(); 

                if(cpuTotal <= 21 && playerTotal == cpuTotal){
                    status.setText("You've Tied"); 
                } else if(cpuTotal <= 21 && playerTotal <= cpuTotal){
                    status.setText("You've lost"); 
                } else {
                    status.setText("You've won"); 
                }
            }
        });
        
        Button newbtn = new Button();
        newbtn.setText("New Hand");
        newbtn.setOnAction((e) -> {
            newHand(); 
        });
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5); 
        
        grid.add(cpuCards, 0, 0, 3, 1); 
        grid.add(cpuLbl, 0, 1);
        grid.add(tLblCpu, 1, 1, 2, 1); 
        grid.add(cards, 0, 3, 3, 1); 
        grid.add(playerLbl, 0, 4);
        grid.add(tLbl, 1, 4, 2, 1);  
        grid.add(drawbtn,0 , 10);
        grid.add(standbtn,1, 10);
        grid.add(newbtn, 2, 10); 
        grid.add(status, 0, 6, 3, 3);
        
        Pane p = new Pane(); 
        p.setPrefSize(0, 100); 
        grid.add(p, 0, 2); 
        
        Scene scene = new Scene(grid, 1500, 800);
        
        primaryStage.setTitle("BlackJack");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        newDeck(); 
        newHand(); 
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
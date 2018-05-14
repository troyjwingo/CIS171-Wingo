package blackjack;

import javafx.scene.image.Image;

public class Card {
   private Suit suitVal;
   private Rank rankVal;
   private Image cardImg;

   public Card( Suit suit, Rank rank, Image cardFace ) {
      cardImg = cardFace;
      suitVal = suit;
      rankVal = rank;
   }

   public static String getFilename( Suit suit, Rank rank ) {
      return "resource/cards/"+rank.getSymbol() + suit.getSymbol() + ".png";
   }

   public Suit getSuit() {
      return suitVal;
   }

   public Rank getRank() {
      return rankVal;
   }
   
   public int getValue() {
       String rank = rankVal.getSymbol();  
       try{
           // try to turn it into an integer 
           return Integer.parseInt(rank);  
       } catch (Exception ex){
           
           // we failed, so it is a letter
           if(rank.equals("a")){
               // it is an ace
               return 11; 
           } else {
               // it is a face card 
               return 10; 
           }
       }
   }

   public Image getCardImage() {
      return cardImg;
   }

   @Override
   public String toString() {
      return rankVal.toString() + " of " + suitVal.toString();
   }

   public String rankToString() {
      return rankVal.toString();
   }

   public String suitToString() {
      return suitVal.toString();
   }
}
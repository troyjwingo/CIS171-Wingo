import java.util.ArrayList;

public class Exercise19_08 {

public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();

        for (int i = 10; i > 0; i--) {
            list1.add(i);
        }//end for
        
        print(list1);
        shuffle(list1);
        print(list1);
        
    }//end main
    //Method to shuffle usng Math.random() and the Temp placeholder value
    public static <E> void shuffle(ArrayList<E> list1) {
        for (int i = 0; i < list1.size(); i++) {
            int randInt = (int)(Math.random() * list1.size());
            E temp = list1.get(randInt);
            list1.set(randInt, list1.get(i));
            list1.set(i, temp);
        }//end for
    }//end method
    //Method to Print the list
    public static <E> void print(ArrayList<E> list) {
        System.out.println(list);
    }//end Method
    
}//end class

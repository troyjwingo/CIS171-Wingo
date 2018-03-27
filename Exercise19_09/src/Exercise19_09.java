import java.util.ArrayList;

public class Exercise19_09 {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();

        for (int i = 10; i > 0; i--) {
            list1.add(i);
        }//end for
        
        print(list1);
        sort(list1);
        print(list1);
        
    }//end main
    //Method to sort ArrayList Items using the compareTo method and a placeholder value
    public static <E extends Comparable<E>> void sort(ArrayList<E> list1) {
        for (int i = 0; i < list1.size() - 1; i++) {
            E tempMin = list1.get(i);
            
            int Min = i;
            
            for (int t = i + 1; t < list1.size(); t++) {
                if (list1.get(t).compareTo(tempMin) < 0) {
                    tempMin = list1.get(t);
                    Min = t;
                }//end if
            }//end for
            if (Min != i) {
                list1.set(Min, list1.get(i));
                list1.set(i, tempMin);
            }//end if
        }//end for
    }//end Method
    //Method to Print the list
    public static <E extends Comparable<E>> void print(ArrayList<E> list) {
        System.out.println(list);
    }//end Method
    
}
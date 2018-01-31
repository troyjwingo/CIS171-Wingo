
public class Assignment13_5 {
    /**
     * Class: Assignment13_5
     * Developer: Troy Wingo
     * Date: 01/29/2018
     * Purpose: To get a better understanding of abstract and comparable interface
     */
    
    public static void main(String[] args) {
        Rectangle[] rectangles = {new Rectangle(20, 20), new Rectangle(30, 30)};

        System.out.println(rectangles[0].Height);
        System.out.println(rectangles[1].Height);
        System.out.println(rectangles[0].compareTo(rectangles[1]));
    }
    
}



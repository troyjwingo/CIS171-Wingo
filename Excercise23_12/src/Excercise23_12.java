import java.util.ArrayList;
public class Excercise23_12 {

    public static void main(String[] args) {
        //variable declaration
        int Max = 1000000;
        long startTime = System.currentTimeMillis();
        int[] sortedList = new int[1000000];
        
        //populates the array with 1000000 random integers
        for (int i = 0; i < sortedList.length; i++) {
            sortedList[i] = (int) (Math.random() * Max);
        }
        //calls radixSort
        radixSort(sortedList, Max);
        
        //Prints Execution time
        System.out.println("Execution Time: " + (System.currentTimeMillis() - startTime));
        
        //Tests the sortedList for Debug
        //for (int i = 0; i < sortedList.length; i++){
        //    System.out.println(sortedList[i]);  
        //}
    }  

    static void radixSort(int[] sortedList, int Max) {
        for (int order = 1; order < Max; order = order * 10) {
            
            ArrayList<Integer>[] tBucket = new ArrayList[10];
            int count = 0;
            
            for (int i = 0; i < tBucket.length; i++) {
                tBucket[i] = new ArrayList<>();
            }

            for (int i = 0; i < sortedList.length; i++) {
                tBucket[(sortedList[i] / order) % 10].add(sortedList[i]);
            }

            for (int i = 0; i < tBucket.length; i++) {
                if (tBucket[i] != null) {
                    for (int t = 0; t < tBucket[i].size(); t++)
                        sortedList[count++] = tBucket[i].get(t);
                }   
            }
        }
    }
}
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Exercise22_8 {
    public static void main(String[] args) throws IOException {
        long n = 1000000000;
  
    RandomAccessFile input = new RandomAccessFile("Exercise22_8.dat", "rw");
    java.util.List<Long> list = new java.util.ArrayList<>();
  
    //Prime number counter
    long pCount = 0; 
    //Prime Test
    long currentNum = 2; 
    //Sqrt Test
    int sqrt = 1; 
  
    if(input.length() > 0) {
        input.seek(input.length() - 8);
        currentNum = input.readLong() + 1;
        input.seek(0);
   
    try {
        for (int i = 0; i < 10000; i++) {
            list.add(input.readLong());
        }   
    } 
    catch (EOFException e) {
    } 
   
    sqrt = (int)(Math.sqrt(currentNum)) + 1;
    pCount = input.length() / 8;
    }
  
  
    while (currentNum <= n) {
        boolean isPrime = true;
        if (sqrt * sqrt < currentNum)
            sqrt++;

        while(true) {
            isPrime = true;
    
            int m;
            for (m = 0; m < list.size() && list.get(m) <= sqrt; m++) {
                if (currentNum % list.get(m) == 0) {
                isPrime = false;
                break;
                }
            }
    
            if (input.getFilePointer() == input.length()) {
                break;
            }
    
            if (!isPrime) {
                break;
            } 
            else  {
                list.clear();
                try {
                    for (int i = 0; i < 10000; i++) {
                        list.add(input.readLong());
                    }
                } 
                catch (EOFException e) {
                }
            }
        }
   
        //Print Prime number counter - current prime - list size
        if (isPrime) {
            currentNum++;
            System.out.println(pCount + "\t" + currentNum + "\t" + list.size());
            input.writeLong(currentNum);
            list.clear();
            input.seek(0);
            try {
                for (int i = 0; i < 10000; i++) {
                list.add(input.readLong());
                }   
            } 
            catch (EOFException e) {
            } 
        }
    currentNum++;
    }
    input.close();
    }
}
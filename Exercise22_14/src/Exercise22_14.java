public class Exercise22_14 {

    public static void main(String[] args) {
        int begin = 8_000_000;
        int end = 18_000_000;
        int increment = 2_000_000;
  
        System.out.print("\t\t|");
        for (int n = begin; n <= end; n += increment) {
            System.out.printf("%14d", n);
        }//end for
        
        System.out.println();
        System.out.print("Listing 24.4\t|");
        
        //Determines the execution time for finding all prime numbers in for values: 8000000 to 18000000 in increments of 2000000 in listing 24.4
        for (int n = begin; n <= end; n += increment) {
            long sTime = System.currentTimeMillis();
            Listing24_4(n);
            long fTime = System.currentTimeMillis();
            long eTime = (fTime - sTime) / 1000;
            
            //Determines chracter spacing
            System.out.printf("%14d",eTime);
        }
        
        System.out.println();
        System.out.print("Listing 24.5\t|");
        
        //Determines the execution time for finding all prime numbers in for values: 8000000 to 18000000 in increments of 2000000 in listing 24.5
        for (int n = begin; n <= end; n += increment) {
            long sTime = System.currentTimeMillis();
            Listing24_5(n);
            long fTime = System.currentTimeMillis();
            long eTime = (fTime - sTime) / 1000;
            
            //Determines chracter spacing
            System.out.printf("%14d", eTime);
        }//end for
        
        System.out.println();
        System.out.print("Listing 24.6\t|");
        
        //Determines the execution time for finding all prime numbers in for values: 8000000 to 18000000 in increments of 2000000 in listing 24.6
        for (int n = begin; n <= end; n += increment) {
            long sTime = System.currentTimeMillis();
            Listing24_6(n);
            long fTime = System.currentTimeMillis();
            long eTime = (fTime - sTime) / 1000;
            
            //Determines chracter spacing
            System.out.printf("%14d", eTime);
        }//end for
    }//end main
    
    // Listing 24.4 Algorithm for finding prime numbers 
    public static int Listing24_4(int n) {
        int count = 0;
        int num = 2;
            while (num <= n) {
                boolean isPrime = true;
                for (int div = 2; div <= (int) (Math.sqrt(num)); div++) {
                    if (num % div == 0) {
                        isPrime = false; 
                        break;
                    }//end fi
                }//end for
                if (isPrime) {
                    count++;
                }//end if
                num++;
            }//end while
        return count;
    }//end method

    public static int Listing24_5(int n) {
        java.util.List<Integer> list = new java.util.ArrayList<Integer>();
        //Field Declaration
        int count = 0;
        int num = 2;
        int sqrt = 1;
        while (num <= n) {
            boolean isPrime = true;
            if (sqrt * sqrt < num)
                sqrt++;
            for (int k = 0; k < list.size() && list.get(k) <= sqrt; k++) {
                if (num % list.get(k) == 0) {
                    isPrime = false;
                    break;
                }//end if
            }//end for
            if (isPrime) {
                count++; 
                list.add(num);
            }//end if
            num++;
        }//end while
        return count;
    }

    public static int Listing24_6(int n) {
        boolean[] primes = new boolean[n + 1];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }//end for
        for (int k = 2; k <= n / k; k++) {
            if (primes[k]) {
                for (int i = k; i <= n / k; i++) {
                    primes[k * i] = false;
                }//end for
            }//end if
        }//end for
        int count = 0;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                count++;
            }//end if
        }//end for
        return count;
    }//end method
}//end class
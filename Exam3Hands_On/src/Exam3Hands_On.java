
import java.util.ArrayList;


public class Exam3Hands_On {
    static int q;
    static int w;
    static int e;
    static int r;
    static int y;
    static int u;
    
    public static void main(String[] args) {
        //variable declaration
        int Max = 1000000;
        
        //execution time storage
        long[] selExec = new long[6];
        long[] radixExec = new long[6];
        long[] bubbleExec = new long[6];
        long[] mergeExec = new long[6];
        long[] quickExec = new long[6];
        long[] heapExec = new long[6];
        
        //parallel array for sorting names
        String[] sortType = new String[6];
        sortType[0] = "Selection Sort"; 
        sortType[1] = "  Radix Sort  "; 
        sortType[2] = "  Bubble Sort "; 
        sortType[3] = "  Merge Sort  "; 
        sortType[4] = "  Quick Sort  ";
        sortType[5] = "  Heap Sort   ";
        
        //Rand Int Storage
        int[] arr50k = new int[50000];
        int[] arr100k = new int[100000];
        int[] arr150k = new int[150000];
        int[] arr200k = new int[200000];
        int[] arr250k = new int[250000];
        int[] arr300k = new int[300000];
        
        callPopulateArray(arr50k, arr100k, arr150k, arr200k, arr250k, arr300k, Max);
        
        //Selection Call
        callSelectionSort(arr50k, Max, selExec);
        callSelectionSort(arr100k, Max, selExec);
        callSelectionSort(arr150k, Max, selExec);
        callSelectionSort(arr200k, Max, selExec);
        callSelectionSort(arr250k, Max, selExec);
        callSelectionSort(arr300k, Max, selExec);
        //end Selection Call
        System.out.println(" ");
        
        callPopulateArray(arr50k, arr100k, arr150k, arr200k, arr250k, arr300k, Max);
        
        //Radix Calls
        callRadixSort(arr50k, Max, radixExec);
        callRadixSort(arr100k, Max, radixExec);
        callRadixSort(arr150k, Max, radixExec);
        callRadixSort(arr200k, Max, radixExec);
        callRadixSort(arr250k, Max, radixExec);
        callRadixSort(arr300k, Max, radixExec);
        //end Radix Call
        System.out.println(" ");
        
        callPopulateArray(arr50k, arr100k, arr150k, arr200k, arr250k, arr300k, Max);
        
        //Bubble Call
        callBubbleSort(arr50k, Max, bubbleExec);
        callBubbleSort(arr100k, Max, bubbleExec);
        callBubbleSort(arr150k, Max, bubbleExec);
        callBubbleSort(arr200k, Max, bubbleExec);
        callBubbleSort(arr250k, Max, bubbleExec);
        callBubbleSort(arr300k, Max, bubbleExec);
        //end Bubble Call
        System.out.println(" ");
        
        callPopulateArray(arr50k, arr100k, arr150k, arr200k, arr250k, arr300k, Max);
        
        //Merge Call
        callMergeSort(arr50k, Max, selExec);
        callMergeSort(arr100k, Max, mergeExec);
        callMergeSort(arr150k, Max, mergeExec);
        callMergeSort(arr200k, Max, mergeExec);
        callMergeSort(arr250k, Max, mergeExec);
        callMergeSort(arr300k, Max, mergeExec);
        //end Merge Call
        System.out.println(" ");
        
        callPopulateArray(arr50k, arr100k, arr150k, arr200k, arr250k, arr300k, Max);
        
        //Quick Call
        callQuickSort(arr50k, Max, quickExec);
        callQuickSort(arr100k, Max, quickExec);
        callQuickSort(arr150k, Max, quickExec);
        callQuickSort(arr200k, Max, quickExec);
        callQuickSort(arr250k, Max, quickExec);
        callQuickSort(arr300k, Max, quickExec);
        //end Quick Call
        System.out.println(" ");
        
        callPopulateArray(arr50k, arr100k, arr150k, arr200k, arr250k, arr300k, Max);
        
        //HeapCall
        callHeapSort(arr50k, Max, heapExec);
        callHeapSort(arr100k, Max, heapExec);
        callHeapSort(arr150k, Max, heapExec);
        callHeapSort(arr200k, Max, heapExec);
        callHeapSort(arr250k, Max, heapExec);
        callHeapSort(arr300k, Max, heapExec);
        //end Heap Call
        System.out.println(" ");
        
        System.out.print("Analysis");
        //System.out.printf("%7s", " ");
        for (int n = 0; n < sortType.length; n++) {
            System.out.printf("%7s", "|");
            System.out.printf("%7s", " ");
            System.out.printf("%7s", sortType[n]);
        }//end for
        
        printMethod(selExec, radixExec, bubbleExec, mergeExec, quickExec, heapExec);
        
        //DebugMethod(arr300k);
    }//end main
    
    public static void printMethod( long[] selExec, long[] radixExec, long[] bubbleExec, long[] mergeExec, long[] quickExec, long[] heapExec){
        System.out.print("Analysis");
        int count = 50000;
        
        //System.out.printf("%7s", " ");
        for (int n = 0; n < 6; n++) {
            
            System.out.println("");
            System.out.print(count);
            if (count == 50000){
            System.out.printf("%10s", "|");
            }//end if
            else {
                System.out.printf("%9s", "|");
            }//end else
            System.out.printf("%7s", " ");
            System.out.printf("%7o", selExec[n]);
            System.out.printf("%14s", "|");
            System.out.printf("%7s", " ");
            System.out.printf("%7o", radixExec[n]);
            System.out.printf("%14s", "|");
            System.out.printf("%7s", " ");
            System.out.printf("%7o", bubbleExec[n]);
            System.out.printf("%14s", "|");
            System.out.printf("%7s", " ");
            System.out.printf("%7o", mergeExec[n]);
            System.out.printf("%14s", "|");
            System.out.printf("%7s", " ");
            System.out.printf("%7o", quickExec[n]);
            System.out.printf("%14s", "|");
            System.out.printf("%7s", " ");
            System.out.printf("%7o", heapExec[n]);
            count = count + 50000;
        }//end for
    }
    
    public static void DebugMethod(int[] currentArray){
        for (int i = 0; i < currentArray.length; i++) {
            System.out.println(currentArray[i]);
        }//end for
    }
    
    static void callPopulateArray(int[] arr50k, int[] arr100k, int[] arr150k, int[] arr200k, int[] arr250k, int[] arr300k, int Max){
        populateArray(arr50k, Max);
        populateArray(arr100k, Max);
        populateArray(arr150k, Max);
        populateArray(arr200k, Max);
        populateArray(arr250k, Max);
        populateArray(arr300k, Max);
    }
    
    static void callSelectionSort(int[] curArray, int Max, long[] selectionExec) {
        //callPopulateArray(arr50k, arr100k, arr150k, arr200k, arr250k, arr300k, Max);
        long startTime = 0;
        long endTime = 0;
        startTime = System.currentTimeMillis();
        selectionSort(curArray);
        endTime = System.currentTimeMillis();
        selectionExec[w] = endTime - startTime;
        //Prints Execution time
        //System.out.printf(" Execution Time: %d \n", selectionExec[w]);
        w++;
    }
    
    static void callRadixSort(int[] curArray, int Max, long[] radixExec) {
        long startTime = 0;
        long endTime = 0;
        startTime = System.currentTimeMillis();
        radixSort(curArray, Max);
        endTime = System.currentTimeMillis();
        radixExec[q] = endTime - startTime;
        q++;
    }
    
    static void callBubbleSort(int[] curArray, int Max, long[] bubbleExec) {
        long startTime = 0;
        long endTime = 0;
        startTime = System.currentTimeMillis();
        bubbleSort(curArray);
        endTime = System.currentTimeMillis();
        bubbleExec[e] = endTime - startTime;
        e++;
    }
    
    static void callMergeSort(int[] curArray, int Max, long[] mergeExec) {
        long startTime = 0;
        long endTime = 0;
        startTime = System.currentTimeMillis();
        mergeSort(curArray);
        endTime = System.currentTimeMillis();
        mergeExec[r] = endTime - startTime;
        r++;
    }
    
    static void callQuickSort(int[] curArray, int Max, long[] quickExec) {
        long startTime = 0;
        long endTime = 0;
        int low = 0;
        int high = curArray.length - 1;
        startTime = System.currentTimeMillis();
        quickSort(curArray, low, high);
        endTime = System.currentTimeMillis();
        quickExec[u] = endTime - startTime;
        u++;
    }
    
    static void callHeapSort(int[] curArray, int Max, long[] heapExec) {
        long startTime = 0;
        long endTime = 0;
        int low = 0;
        int high = curArray.length - 1;
        startTime = System.currentTimeMillis();
        heapSort(curArray);
        endTime = System.currentTimeMillis();
        heapExec[y] = endTime - startTime;
        y++;
    }
    
    static void populateArray(int[] sortedList, int Max){
        for (int i = 0; i < sortedList.length; i++) {
            sortedList[i] = (int) (Math.random() * Max);
        }
    }
    
    static void selectionSort(int[] sortedList) {
        for (int i = 0; i < sortedList.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < sortedList.length; j++){  
                if (sortedList[j] < sortedList[index]){  
                    index = j;//searching for lowest index  
                }  
            }  
            int smallerNumber = sortedList[index];   
            sortedList[index] = sortedList[i];  
            sortedList[i] = smallerNumber;  
        }  
    }
    
    
    //Radix Sorts array parameters
    static void radixSort(int[] sortedList, int Max) {
        for (int order = 1; order < Max; order = order * 10) {
            
            ArrayList<Integer>[] tBucket = new ArrayList[10];
            int count = 0;
            
            for (int i = 0; i < tBucket.length; i++) {
                tBucket[i] = new ArrayList<>();
            }//end for

            for (int i = 0; i < sortedList.length; i++) {
                tBucket[(sortedList[i] / order) % 10].add(sortedList[i]);
            }//end for

            for (int i = 0; i < tBucket.length; i++) {
                if (tBucket[i] != null) {
                    for (int t = 0; t < tBucket[i].size(); t++)
                        sortedList[count++] = tBucket[i].get(t);
                }//end if  
            }// end for
        }
    }
    
    //Bubble Sorts array parameters
    static void bubbleSort(int[] sortedList) {  
        int n = sortedList.length;  
        int temp = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(sortedList[j-1] > sortedList[j]){  
                                 //swap elements  
                                 temp = sortedList[j-1];  
                                 sortedList[j-1] = sortedList[j];  
                                 sortedList[j] = temp;  
                         }  
                          
                 }  
         }  
  
    }
    //Merge Sorts array parameters
    public static void mergeSort(int[] sortedList) {
        int size = sortedList.length;
        if (size < 2){
            return;
        }
        int mid = size / 2;
        int leftSize = mid;
        int rightSize = size - mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        for (int i = 0; i < mid; i++) {
            left[i] = sortedList[i];
        }// end for
        for (int i = mid; i < size; i++) {
            right[i - mid] = sortedList[i];
        }// end for
        mergeSort(left);
        mergeSort(right);
        merge(left, right, sortedList);
    }

    public static void merge(int[] left, int[] right, int[] sortedList) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, p = 0, b = 0;
        while (i < leftSize && p < rightSize) {
            if (left[i] <= right[p]) {
                sortedList[b] = left[i];
                i++;
                b++;
            } else {
                sortedList[b] = right[p];
                b++;
                p++;
            }
        }
        while (i < leftSize) {
            sortedList[b] = left[i];
            b++;
            i++;
        }
        while (p < leftSize) {
            sortedList[b] = right[p];
            b++;
            p++;
        }
    }
    
    public static void quickSort(int[] sortedList, int low, int high) {
		if (sortedList == null || sortedList.length == 0)
			return;
 
		if (low >= high){
                    return;
                }
			
		int middle = low + (high - low) / 2;
		int pivot = sortedList[middle];
		int i = low, j = high;
                
		while (i <= j) {
                    while (sortedList[i] < pivot) {
			i++;
                    }
 
                    while (sortedList[j] > pivot) {
			j--;
                    }
 
			if (i <= j) {
                            int temp = sortedList[i];
                            sortedList[i] = sortedList[j];
                            sortedList[j] = temp;
                            i++;
                            j--;
			}
		}
                
		if (low < j){
                    quickSort(sortedList, low, j);
                }
		if (high > i){
                    quickSort(sortedList, i, high);
                }
			
    }
    
    public static void heapSort(int sortedList[])
    {
        int n = sortedList.length;
 
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(sortedList, n, i);
 
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = sortedList[0];
            sortedList[0] = sortedList[i];
            sortedList[i] = temp;
            heapify(sortedList, i, 0);
        }
    }
 
    public static void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
 
        if (l < n && arr[l] > arr[largest]){
            largest = l;
        }
        
        if (r < n && arr[r] > arr[largest]){
            largest = r;
        }
 
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
    
}
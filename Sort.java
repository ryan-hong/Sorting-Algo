import java.util.*;

public class Sort{

  public static void main(String[] args){
    Random r = new Random();
    System.out.println("What size array would you like?");
    
    Scanner scan = new Scanner(System.in);
    int[] unsorted = new int[scan.nextInt()];

    for (int i = 0; i < unsorted.length; i++){
      unsorted[i] = r.nextInt(50);
    }

    System.out.print("unsorted array: | ");
    for (int i = 0; i < unsorted.length; i++){
      System.out.print(unsorted[i] + " | ");
    }

    System.out.println();
    mergeSort(unsorted);
    System.out.println();
    System.out.print("sorted array: | ");
    for (int i = 0; i < unsorted.length; i++){
      System.out.print(unsorted[i] + " | ");
    }

  }
  
  /**
   * merge() takes in subarrays and original array and merges them all back together to create a finalized sorted array
   * @param L - subarray of A
   * @param R - subarray of A
   * @param A - original unsorted array
   */
  public static void merge(int[] L, int[] R, int[] A){
    int lsize = L.length;
    int rsize = R.length;
    int i = 0, j = 0, k = 0;

    //while loop to compare subarray elements
    while (i < lsize && j < rsize){
      if (L[i] <= R[j]){
        A[k] = L[i];       
        i++;
      }
      else {
        A[k] = R[j];
        j++;
      }
      k++;
    }

    //if one subarray still has elements left, add it to the array
    while (i < lsize){
      A[k] = L[i];
      i++;
      k++;
    }

    while (j < rsize){
      A[k] = R[j];
      j++;
      k++;
    }
  }
  
  /**
   * mergeSort() takes in orginal unsorted array and splits into subarrays recursively.  When all subarrays are of smallest size
   * (after recursiion), mergeSort calls merge() which puts all subarrays back into one array
   * @param A - original unsorted array
   */
  public static void mergeSort(int[] A){
    int size = A.length;

    //array is already sorted if size is less than 2
    if (size < 2){
      return;
    }

    //mid point to split array into subarrays left and right
    int mid = size/2;
    int[] left = new int[mid];
    int[] right = new int[size-mid];

    //iterate through array to fill in subarrays, dependent on the mid point
    for (int i = 0; i < mid; i++){
      left[i] = A[i];
    }
    for (int i = mid; i < size; i++){
      right[i-mid] = A[i];
    }
   
    //recursive call to keep splitting into subarrays until smallest array size achieved
    mergeSort(left);
    mergeSort(right);
    merge(left, right, A);
  }
}
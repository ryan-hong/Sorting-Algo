import java.util.*;

public class Sort{

  public static void main(String[] args){
    int[] unsorted = new int[5];
    Scanner scan = new Scanner(System.in);
    
    for (int i = 0; i < unsorted.length; i++){
      unsorted[i] = scan.nextInt();
    }

    System.out.print("unsorted array: ");
    for (int i = 0; i < unsorted.length; i++){
      System.out.print(unsorted[i] + " | ");
    }
  }

  public void merge(int[] L, int[] R, int[] A){
    int lsize = L.length;
    int rsize = R.length;
    int i = 0, j = 0, k = 0;

    while (i < lsize && j < rsize){
      if (L[i] <= R[j]){
        A[k] = L[i];
        k++;
        i++;
      }
      else {
        A[k] = R[j];
        k++;
        j++;
      }
    }
  }

  public void mergeSort(int[] A){
    int size = A.length;
    if (size < 2){
      return;
    }

    int mid = size/2;
    int[] left = new int[mid];
    int[] right = new int[size-mid];

    for (int i = 0; i < mid-1; i++){
      left[i] = A[i];
    }

    for (int i = mid-1; i < size-1; i++){
      right[i] = A[i];
    }
   
    mergeSort(left);
    mergeSort(right);

  }
}
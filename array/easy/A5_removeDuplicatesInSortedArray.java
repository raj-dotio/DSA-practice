import java.util.Arrays;
import java.util.HashSet;

public class A5_removeDuplicatesInSortedArray {

  //& brute using HashSet TC: O(n + nlogn) , SC: O(n)
  public static void brute(int arr[]){
    HashSet<Integer> set = new HashSet<>(); //HashSet remove any duplicates by it self
    // for(int i=0; i<arr.length; i++){ //to move index time : O(n)
    //   set.add(arr[i]); //in adding it takes time:O(logn)
    // }
    for(int val: arr){ // O(n)
      set.add(val); // it takes time: O(logn)
    }

    System.out.println(set);
  }

  //& mine time: O(n) space: O(n)
  public static void mine_wasbetter(int arr[]){
    int prev = arr[0];
    int newarr[] = new int[arr.length];
    newarr[0] = arr[0];
    int k=1;
    for(int i=1; i<arr.length; i++){
      if(arr[i]>prev){
        prev = arr[i];
        newarr[k] = prev;
        k++;
      }
    }
    System.out.println(Arrays.toString(newarr));
  }

  //& two pointer Approch time: O(n) space: O(1)
  public static void optimal(int arr[]){
    int i=0, j=1;
    while(j<arr.length){
      if(arr[j]!=arr[i]){
        arr[i+1]=arr[j];
        i++;
      }
      j++;
    }
    // System.out.println(Arrays.toString(arr));
    //to print
    for(int k=0; k<i+1; k++){
      System.out.print(arr[k] + " ");
    }
  }
  public static void main(String[] args) {
    int arr[] = {1,1,2,2,2,3,3,4,4};
    mine_wasbetter(arr);
    // optimal(arr);
    // brute(arr);
  }
}

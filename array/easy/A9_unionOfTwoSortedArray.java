package easy;
import java.util.*;

public class A9_unionOfTwoSortedArray {

  //& Hashset- time: O(n1logn + n2logn)+O(n1+n2) , space: O(n1+n2), and O(n1+n2) only for return the answerver 
  public static void brute(int arr1[], int arr2[]){
    HashSet<Integer> set = new HashSet<>();
    // time: O(n1logn)
    for(int val: arr1){
      set.add(val);
    }
    // time: O(n2logn)
    for(int val: arr2){
      set.add(val);
    }
    // storing in ans array time:O(n1+n2) //{if both array contains totally diff elems}
    int union[] = new int[set.size()];
    int i=0;
    for(int val: set){
      union[i++]= val;
    }
    System.out.println(Arrays.toString(union));
  }  



  //& optimal: time: O(n), space: O(n)
  public static void mine_wasOptimal(int arr1[], int arr2[]){
    int i=0, j=0;
    int n1= arr1.length;
    int n2= arr2.length;
    int union[] = new int[n1+ n2];
    int k=0;
    while(i<arr1.length && j<arr2.length){
      if(arr1[i]<arr2[j]){
        if(k == 0 || union[k - 1] != arr1[i]){
          union[k++] = arr1[i];
        }
        i++;
      }else if(arr1[i]>arr2[j]){
        if(k == 0 || union[k - 1] != arr2[j]){
          union[k++] = arr2[j];
        }
        j++;
      }else{
        if (k == 0 || union[k - 1] != arr1[i]) {
          union[k++] = arr1[i];
        }
        i++; 
        j++;
      }
    }
    // remaining arr1
    while (i < n1) {
        if (k == 0 || union[k - 1] != arr1[i]) {
            union[k++] = arr1[i];
        }
        i++;
    }
    // remaining arr2
    while (j < n2) {
        if (k == 0 || union[k - 1] != arr2[j]) {
            union[k++] = arr2[j];
        }
        j++;
    }
    System.out.println(Arrays.toString(union));
  }
  public static void main(String[] args) {
    int arr1[] = {1,1,2,3,4,5};
    int arr2[] = {2,3,4,4,5};
    // mine_wasOptimal(arr1, arr2);
    brute(arr1, arr2);
  }
}

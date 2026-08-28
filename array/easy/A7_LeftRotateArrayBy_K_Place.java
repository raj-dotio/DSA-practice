/*
* PROBLEM: Left Rotate Array by K Places
* MEANING:
array ko left shift karo by k times
first k elements ko last me daalna hai
* EXAMPLE:
[1,2,3,4,5], k=2 → [3,4,5,1,2]
CORE IDEA (optimal - reversal):
1. reverse(0 → k-1)
2. reverse(k → n-1)
3. reverse(0 → n-1)
MEMORY LINE:
* "pehle k reverse, baaki reverse, phir pura reverse"
*/


import java.util.Arrays;

public class A7_LeftRotateArrayBy_K_Place {

  //& brute: time; O(3n)
  public static void mine_wasBrute(int arr[], int d){
    int n = arr.length;
    d = d % n;
    // int temp[] = new int[d];
    // for(int i=0; i<d; i++){
    //   temp[i] = arr[i];
    // }
    int[] temp = Arrays.copyOf(arr, d);

    for(int i=d; i<n; i++){
      arr[i-d] = arr[i];
    }
    for(int i=n-d; i<n; i++){
      arr[i] = temp[i-(n-d)];
    }
    System.out.println(Arrays.toString(arr));
  }

  
  //& optimla: time: O(n)
  // Case 1: Primitive (int, double, etc.) 👉 original variable change ❌ nahi hoga
  //🔥 Case 2: Array / Object (tera case) 👉 original array change ✅ hoga
    // array ka reference (address) copy karta hai
    // dono (main + function) same array ko point karte hain
  public static void optimal(int arr[], int d){
    d = d % arr.length;
    reverse(arr, 0, d-1);
    reverse(arr, d, arr.length-1);
    reverse(arr, 0, arr.length-1);
    System.out.println(Arrays.toString(arr));
  }
  // reverse using two ptr approch
  public static void reverse(int arr[], int l, int r){
    while(l<=r){
      int temp = arr[l];
      arr[l++] = arr[r];
      arr[r--] = temp;
    }
  }


  public static void main(String[] args) {
    int arr[] = {1,2,3,4,5};
    System.out.println(Arrays.toString(arr));
    // mine_wasBrute(arr, 6);
    optimal(arr, 2);
  }
}

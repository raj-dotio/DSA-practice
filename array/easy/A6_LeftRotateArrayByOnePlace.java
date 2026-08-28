//yellow PROBLEM: Left Rotate Array by One Place
/*
* MEANING:
  array ko left shift karo by 1
  first element ko last me daalna hai
  EXAMPLE:
  input:  [1, 2, 3, 4, 5]
  output: [2, 3, 4, 5, 1] 
*/

// STEPS (thinking):
// 1. first element store karo (temp)
// 2. sab elements ko left shift karo (i → i-1)
// 3. last index pe temp daal do

// PATTERN:
// shifting / rotation

// EDGE CASE:
// size = 0 ya 1 → kuch change nahi

// REAL LINE (yaad rakh):
// "pehla hatao, baaki slide karo, last me chipkao"

import java.util.Arrays;

public class A6_LeftRotateArrayByOnePlace {
  
  public static void mine(int arr[]){
    int temp = arr[0];
    for(int i=0; i<arr.length-1; i++){
      arr[i] = arr[i+1];
    }
    arr[arr.length-1] = temp;
    System.out.println(Arrays.toString(arr));
  }
  public static void main(String[] args) {
    int arr[] = {1,2,3,4,5};
    System.out.println(Arrays.toString(arr));
    mine(arr);
  }
}

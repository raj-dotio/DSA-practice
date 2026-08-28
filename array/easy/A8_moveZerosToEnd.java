/*
* PROBLEM: Move Zeros to End

* MEANING:
  array me jitne 0 hain unhe end me le jana hai
  baaki elements ka order same rehna chahiye
  EXAMPLE:
  [0,1,0,3,12] → [1,3,12,0,0]
  CORE IDEA (optimal):
  i = position of next non-zero
  j = traversal pointer always at zero
  if arr[j] != 0:
    swap(arr[i], arr[j])
    i++
* PATTERN:
  * two pointers / in-place shifting

* EDGE:
  all zeros → same
  no zeros → same
TIME: O(n)
SPACE: O(1)

MEMORY LINE:
* "non-zero ko aage kheecho, zero apne aap peeche chale jayenge"
*/

import java.util.Arrays;

public class A8_moveZerosToEnd {
  //& brute- time: O(2n) , space: O(n)
  public static void brute(int arr[]){
    //1.loop -store all non zero in temp[] array - time: O(n)
    //2.loop -assign them to the starting of arr(in og array) - time: O(x)
    //3.loop -remaing last change with 0. time: O(n-x)
  }


  //& optimal- time: O(n) space: O(1)
  public static void mine_wasOptimal(int arr[]){
    int j=1;
    for(int i=0; i<arr.length; i++){
      if(arr[i]==0){
        j = i; 
        break;
      }
    }
    for(int i=j+1; i<arr.length; i++){
      if(arr[i]!=0){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        j++;
      }
    }
    System.out.println(Arrays.toString(arr));
  }

  public static void main(String[] args) {
    int arr[] = {1,0,2,3,2,0,0,4,5,1};
    System.out.println(Arrays.toString(arr));
    mine_wasOptimal(arr);
  }
}

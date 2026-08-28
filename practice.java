import java.util.Arrays;

public class practice {
  //removeDuplicates  

  
  public static void mine(int[] arr){ //k is the number of rotations 
    int xor1=0;
    for(int i=0; i<n; i++){
      xor1 ^= arr[i];
    }
    System.out.println(xor1);
  }
  
  public static void main(String[] args){
    int arr[] = {1,1,2,3,3,4,4};
    mine(arr);
  }





  public static void reverse(int arr[], int l, int r){
    while(l<=r){
      int temp = arr[l];
      arr[l++] = arr[r];
      arr[r--] = temp;
    }
  }
}

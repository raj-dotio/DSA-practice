public class A4_checkIfSorted {

  public static void brute(int arr[]){
    // time: O(n^2)
  }

  //& optimal => time: O(n) 
  public static boolean mine_wasOptimal(int arr[]){
    for(int i=1; i<arr.length-1; i++){
      if(arr[i]>arr[i+1]){
        return false;
      }else{
      }
    }
    return true;
  }
  
  //^ if array is rotated sorted then EX - [3, 4, 5, 1, 2] then
  public static boolean check(int arr[]){
    int count = 0;
    for(int i=0; i<arr.length; i++){
      if(arr[i]>arr[(i+1) % arr.length]){
        count ++;
      }
    }
    return count <= 1;
  }

  public static void main(String[] args) {
    int arr[] = {1,2,2,5,3,4};
    if(mine_wasOptimal(arr)){
      System.out.println("sorted array");
    }else{
      System.out.println("unsorted array");
    }
  }
}

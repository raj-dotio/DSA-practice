package easy;
public class A2_largestElement {

  //& time complexity: O(nlogn)  space: O(1)
  public static void brute(int arr[]){
    // using any sorting algo then take its last elem
  }

  //& time comp: O(n)  space comp: O(1)
  public static void mine_wasOptimal(int arr[]){
    int largest= Integer.MIN_VALUE;
    for(int i=0; i<=arr.length-1; i++){
      if(arr[i]>largest){
        largest = arr[i];
      }
    }
    System.out.println(largest);
  }

  public static void main(String[] args) {
    int arr[] = {3,2,1,5,2};
    mine_wasOptimal(arr);
  }
}

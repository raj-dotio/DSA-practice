package easy;
public class A3_secondLargest {
  
  //& time: O(nlogn + n)
  public static void brute(int arr[]){
    // first sort an array time O(nlogn)
    // finding seclargest by comparing it with largest (last index value) take max time O(n)
  }

  //& time: O(2n)
  public static void better(int arr[]){
    // using two 'for' loops: 1.(to find largest) 2.(to find seclargest using largest)
  }

  //& time: O(n) 
  public static void mine_wasOptimal(int arr[]){
    int largest = Integer.MIN_VALUE, secLargest = largest;
    for(int i=0; i<arr.length; i++){
      if(arr[i] > largest){
        secLargest = largest;
        largest = arr[i];
      }else if(arr[i]< largest && arr[i]>secLargest ){
        secLargest = arr[i];
      }
    }
    System.out.println(secLargest);
  }

  public static void main(String[] args) {
    int arr[] = {1,2,4,7,7,5};
    mine_wasOptimal(arr);
  }
}

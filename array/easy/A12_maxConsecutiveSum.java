public class A12_maxConsecutiveSum {

  //& optimal (simple) : time: O(n)
  public static void mine_wasOptimal(int arr[]){
    int count = 0;
    int max = Integer.MIN_VALUE;
    for(int i=0; i<arr.length; i++){
      if(arr[i]==1){
        count++;
        max = Math.max(max, count);
      }else{
        count = 0;
      }
    }
    System.out.println(max);
  }
  public static void main(String[] args) {
    int arr[] = {1,1,0,1,1,1,0,1,1};
    mine_wasOptimal(arr);
  }
}

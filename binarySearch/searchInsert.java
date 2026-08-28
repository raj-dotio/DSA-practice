

public class searchInsert {
  public static void brute(int arr[], int x){
    //time: O(n)
  }

  public static void mine(int arr[], int x){
    int low = 0 , high = arr.length-1;
    int ans = arr.length;
    while(low<=high){
      int mid = (low+high)/2;
      if(arr[mid] >= x){
        ans = mid;
        high = mid-1;
      }else{
        low = mid+1;
      }
    }
    System.out.println(ans);
  }

  public static void main(String[] args) {
    int arr[] = {1,2,4,7};
    mine(arr, 6);
  }
}

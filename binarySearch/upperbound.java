public class upperbound {
  public static void brute(int arr[]){
    // time : O(n) checking one by one
  }

  public static int optimal(int arr[], int x){
    int low = 0, high = arr.length-1;
    int hb = arr.length;
    while(low <= high){
      int mid = (low+high)/2;
      if(arr[mid] > x){
        hb = mid;
        high = mid-1;
      }else{
        low = mid+1;
      }
    }
    return hb;
  }

  public static void main(String[] args) {
    int arr[] = {1,2,3,3,5,8,8,10,10,11};
    System.out.println(optimal(arr, 8));
  }
}



//* lowerBound : array me lowest index jahan (arr[idx] >= target) ho

public class lowerBound{
  public static void brute(int arr[]){
    // time : O(n) checking one by one
  }

  public static int optimal(int arr[], int x){
    int low = 0, high = arr.length-1;
    int lb = arr.length;
    while(low <= high){
      int mid = (low+high)/2;
      if(arr[mid] >= x){
        lb = mid;
        high = mid-1;
      }else{
        low = mid+1;
      }
    }
    return lb;
  }

  public static void main(String[] args) {
    int arr[] = {1,2,3,3,5,8,8,10,10,11};
    System.out.println(optimal(arr, 4));
  }
}

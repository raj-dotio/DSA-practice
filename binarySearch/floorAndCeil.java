// Floor: largest no. in array <= x
// Ceil: smallest no. in array >= x

public class floorAndCeil {
  public static void floor(int arr[], int x){
    int ans = -1;
    int low=0, high= arr.length-1;
    while(low<=high){
      int mid = (low+high)/2;
      if(arr[mid] <= x){
        ans = arr[mid];
        low = mid+1;
      }else{
        high = mid-1;
      }
    }
    System.out.println(ans);
  }

  public static void ceil(int arr[], int x) {
    // its nothing but lowerbound
  }

  public static void main(String[] args) {
    int arr[] = {10, 20, 30, 40,50};
    floor(arr, 10);
  }
}

//* main motive to identify which half should be eleminated

public class searchInRotatedSortedArray_1{

  // public static void mine(int arr[], int x){
  //   int n = arr.length;
  //   int i=0;
  //   while(arr[i+1]<arr[i]){
  //     i++;
  //   }
  //   int low = i+1, high = i;
  // }

  //& time: O(logn)
  //yellow approch 1st find the sorted half then find in another half which is not sorted
  public static int optimal(int arr[], int x){
    int low=0, high = arr.length-1;
    while(low<=high){
      int mid = (low+high)/2;
      if(arr[mid]==x) return mid;
        //left half is sorted if:
      if(arr[low]<=arr[mid]){
        if(arr[low]<=x && x<=arr[mid]){
          high = mid-1;
        }else{
          low = mid+1;
        }
      }// right half is sorted
      else{
        if(arr[mid]<=x && x<=arr[high]){
          low = mid+1;
        }else{
          high = mid-1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int arr[] = {7,8,9,1,2,3,4,5,6};
    System.out.println(optimal(arr, 1));
  }
}

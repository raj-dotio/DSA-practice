// Question. Given an integer array nums, sorted in ascending order (may contain duplicate values) and a target value k. Now the array is rotated at some pivot point unknown to you. Return True if k is present and otherwise, return False.
//yellow when duplicates are present it will be difficult to find.
/*
  example: [3,1,2,3,3,3,3]   //yellow here you can do not get sorted half by comparing low high mid {coz arr[low] == arr[mid] == arr[high]}
  we have to add one more condition for this as well
*/

public class searchInRotatedSortedArray_2 {

  public static boolean optimal(int arr[], int x){
    int low =0, high = arr.length-1;
    while(low<=high){
      int mid = (low+high)/2;
      if(arr[mid]==x) return true;
      if(arr[low]==arr[mid] && arr[mid]==arr[high]){
        low++; high--;
        continue;
      }

      if(arr[low]<=arr[mid]){
        if(arr[low]<=x && x<=arr[mid]){
          high = mid-1;
        }else{
          low = mid+1;
        }
      }else{
        if(arr[mid]<=x && x<=arr[high]){
          low= mid+1;
        }else{
          high = mid-1;
        }
      }
    }
    return false;
  }
  public static void main(String[] args){
    int arr[] = {3,1,2,3,3,3,3};
    System.out.println(optimal(arr, 4));
  }
}

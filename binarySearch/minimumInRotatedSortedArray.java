/*
PROBLEM: Minimum in Rotated Sorted Array

MEANING:
sorted array ko rotate kiya gaya hai
minimum element find karna hai

EXAMPLE:
[3,4,5,1,2] → 1
[4,5,6,7,0,1,2] → 0
[1,2,3,4] → 1 (no rotation)

CORE IDEA (binary search):
minimum hamesha unsorted part me hota hai
but sorted half may or may not contain min elem
*idea-  pick the min from sorted half then compare it in non sorted

if arr[mid] <= arr[high]:
    right part sorted → min left me ho sakta hai //& (mid)
    high = mid
else:
    left sorted → min right me hai
    low = mid + 1

PATTERN:
binary search on rotated array

EDGE:
single element → wahi answer
already sorted → arr[0]

TIME: O(log n)
SPACE: O(1)

MEMORY LINE:
"sorted part ko ignore karo, unsorted me ghuso"
*/


public class minimumInRotatedSortedArray {
  
  //& optimal- time: O(logn), space: O(1)
  public static void Optimal_couldMine(int arr[]){
    int low=0, high= arr.length-1;
    int min = Integer.MAX_VALUE;
    while(low <= high){
      int mid = (low+high)/2;
      // min = Math.min(min, arr[mid]);
      if(arr[low]<=arr[mid]){
        min = Math.min(min, arr[low]);
        low = mid+1;
      }else{
        min = Math.min(min, arr[mid]);
        high = mid-1;
      }
    }
    System.out.println(min);
  }

  public static void main(String[] args) {
    int arr[] = {4,5,6,7,0,1,2};      
    // int arr2[] = {4,5,1,2,3};
    Optimal_couldMine(arr);
  }
}

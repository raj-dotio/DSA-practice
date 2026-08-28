/*
PROBLEM: Single Element in Sorted Array

MEANING:
sorted array me har element 2 baar hai
sirf 1 element single hai → usko find karo

EXAMPLE:
[1,1,2,3,3,4,4] → 2

CORE IDEA (binary search):
pairs always (even, odd) index pe hote hain

before single:
(index even → same next)
(index odd → same prev)

after single:
pattern break ho jaata hai

LOGIC:
if mid even:
    nums[mid] == nums[mid+1] → right jao
    else → left me answer

if mid odd:
    nums[mid] == nums[mid-1] → right jao
    else → left

PATTERN:
binary search + index trick

EDGE:
single element → wahi answer

TIME: O(log n)
SPACE: O(1)

MEMORY LINE:
"pair pattern tootega jahan, wahi single hoga"
*/

/*
PROBLEM: Single Element in Sorted Array

ARRAY:
index:  0 1 2 3 4 5 6 7 8
arr:   [1 1 2 2 3 4 4 5 5]
                ↑
              single (3)
----------------------------------------
OBSERVATION:

BEFORE single:
(1,1) (2,2)
index → even, odd
pattern → correct pairs //* (elem is on right half)

AFTER single:
(4,4) (5,5)
index → odd, even ❌ (pattern shift) //* (elem is on left half)
----------------------------------------
CORE IDEA:
mid even:
    if arr[mid] == arr[mid+1]
        → left part perfect → go RIGHT
    else
        → break → go LEFT
mid odd:
    if arr[mid] == arr[mid-1]
        → left part perfect → go RIGHT
    else
        → break → go LEFT
----------------------------------------
PATTERN BREAK:
"jaha pair alignment tootega → wahi single hai"
----------------------------------------
FLOW:
even index → check right
odd index  → check left
----------------------------------------
EDGE:
size = 1 → return arr[0]
----------------------------------------
TIME: O(log n)
----------------------------------------
MEMORY LINE:
"even-odd sahi hai → aage ja
galat hai → peeche aa"
*/

//* singleNonDuplicate
public class singleElemInSortedArray {

  // brute: time: O(n)
  public static void mine_wasBrute(int arr[]){
    for(int i=0; i<arr.length; i+=2){
      if((arr[i]+arr[i+1])%2 != 0){
        System.out.printf("%d is appearing once.", arr[i]);
        break;
      }
    }
  }



  // me- time: O(logn)
  public static int optimal(int arr[], int n){ // n- size of array

    if(n==1) return arr[0];
    if(arr[0] != arr[1]) return arr[0];
    if(arr[n-1] != arr[n-2]) return arr[n-1];
    
    int low=1; int high=arr.length-2; 
    while(low <= high){ 
      int mid = (low+high)/2;

      if(arr[mid] != arr[mid+1] && arr[mid] != arr[mid-1]){
        return arr[mid];
      }
      //eleminate that part where your elem is not there 
      if(mid%2 ==0){ // mid is even
        if(arr[mid] == arr[mid+1]){  // means pair(even , odd) so check right half
          low = mid+1;
        }else{
          high = mid-1;
        }
      }else{ // mid is odd
        if(arr[mid] == arr[mid-1]){  // means  pair(even , odd) so check right half
          low = mid+1;
        }else{
          high = mid-1;
        }
      }
    }
    return -1;
  }
  

  // striver- time: O(logn)
  public static int OptimalS(int arr, int n) {
    // likhna h 
    return -1;
  }


  //& chatgpt-  time: O(logn)
  public static int mostOptimal(int nums[]) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;

            // make mid even
            if (mid % 2 == 1) mid--;

            if (nums[mid] == nums[mid + 1]) {
                // pair correct → move right
                low = mid + 2;
            } else {
                // pattern break → move left
                high = mid;
            }
        }

        return nums[low];
    }


  public static void main(String[] args) {
    int arr[] = {1,1,2,2,3,3,4,5,5,6,6};
    // mine(arr);
    // System.out.println(optimal(arr, arr.length));
    System.out.println(mostOptimal(arr));

  }
}

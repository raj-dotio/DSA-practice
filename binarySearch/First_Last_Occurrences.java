
public class First_Last_Occurrences{

  //& if not sorted 
  public static void mine1_wasBrute(int arr[], int x){
    int first=0, last=arr.length-1;
    while(first<last){
      if(arr[first]!=x){
        first++;
      }
      if(arr[last]!=x){
        last--;
      }
      if(arr[first]==x && arr[last]==x){
        break;
      }
    }
    System.out.println("("+first+","+last+")");
  }



  //& if sorted (using binary search)
  //& time: 2*O(logn)
  public static int lowerBound(int arr[], int x){
    int low = 0, high = arr.length-1;
    int lb = -1;
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
  public static int upperBound(int arr[], int x){
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

  public static void mine2_optimal(int arr[], int x){
    int first = lowerBound(arr, x);
    if(first == -1 || arr[first] != x){
      first = -1;
    }
    int last = upperBound(arr, x) -1;
    if(arr[last] !=x){
      last = -1;
    }
    System.out.println("("+first+","+last+")");
  }

  //& if interviewee not ask for lb and up
  public static void optimal(int arr[], int x){
    int first=-1, last=-1;

    int low=0, high=arr.length-1;
    while(low<high){
      int mid = (low+high)/2;
      if(arr[mid]==x){
        first = mid;
        high = mid-1;
      }else if(arr[mid]>x){
        high =  mid-1;
      }else{
        low = mid+1;
      }
    }
    low =0;
    high = arr.length-1;
    while(low<high){
      int mid = (low+high)/2;
      if(arr[mid]==x){
        last = mid;
        low = mid+1;
      }else if(arr[mid]>x){
        low =  mid+1;
      }else{
        high = mid-1;
      }
    }

    System.out.println("("+first+","+last+")");
  }


  public static void main(String[] args) {
    // int arr[] = {2,4,6,8,8,8,11,13};
    // mine1_wasBrute(arr, 8);
    // mine2_optimal(arr, 3);
    int arr[] = {2,8,8,8,8,8,11,13};
    optimal(arr, 11);
  }
}

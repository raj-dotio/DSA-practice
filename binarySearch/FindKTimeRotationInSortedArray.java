// in order to find how many rotations was occured { find minimum no. index}


public class FindKTimeRotationInSortedArray {

  public static void mine(int arr[]){
    int low=0 , high = arr.length-1;
    int min=Integer.MAX_VALUE , minidx=-1;
    while(low<=high){
      int mid = (low+high)/2;
      
      if(arr[low]<=arr[mid]){

        if(arr[low]<min){
          min = arr[low];
          minidx = low;
        }
        low = mid+1;
      }else{
        if(arr[mid]< min){
          min = arr[mid];
          minidx = mid;
        }
        high = mid-1;
      }
    }
    System.out.println(minidx);
    // System.out.println(min);
  }

  public static void main(String[] args) {
    int arr[] = {3,4,5,5,1,2,3};
    mine(arr);
  }
}

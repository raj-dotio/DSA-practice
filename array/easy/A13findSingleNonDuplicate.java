
import java.util.HashMap;


public class findSingleNonDuplicate { 
  //& bruteforce
  public static void brute(int arr[]){
    // time: O(n^2)
  }

  
  //& using hashing - time: O(3n) , space: O(max limit)
  public static void better(int arr[]){
    int max = Integer.MIN_VALUE;
    for(int i=0; i<arr.length; i++){
      max = Math.max(arr[i], max);
    }
    int hash[] = new int[max+1];
    for(int i=0; i<arr.length; i++){
      hash[arr[i]] += 1;
    }
    // System.out.println(Arrays.toString(hash));
    for(int i=0 ; i<hash.length; i++){
      if(hash[i]==1){
        System.out.printf("%d appears only once.", i);
        break;
      }
    }
  }


  //& most better (using HashMap)
  public static void most_better(int arr[]){
    HashMap<Long,Integer> map = new HashMap<>();
    for(int i=0; i<arr.length; i++){
      // map.put(arr[i], 1);
    }
  }

  public static void main(String[] args) {
    int arr[] = {1,1,2,3,3,4,4};
    better(arr);
  }
}

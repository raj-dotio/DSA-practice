package medium;

//positives

import java.util.HashMap;

public class A14_longestSubarrayWithKSum {

  // & bruteforce approch O(n^2)
  public static void brute(int[] arr, int k) {
    int maxLen = 0;
    for (int i = 0; i < arr.length; i++) {
      int sum = 0;
      for (int j = i; j < arr.length; j++) {
        sum += arr[j];
        if (sum == k) {
          maxLen = Math.max(maxLen, j - i + 1);
        }
      }
    }
    System.out.println(maxLen);
  }

  // Longest Subarray with Sum K
  // Subarray must be contiguous (continuous elements).
  //
  // Pattern: Prefix Sum + HashMap
  // Keep prefix sum while traversing.
  // If currentSum - K was seen before,
  // the elements between those indices have sum K.
  //
  // Store the FIRST occurrence of each prefix sum
  // to get the longest possible subarray.
  //
  // Example:
  // [1, 2, 3, 1, 1], K = 6
  // Longest subarray → [1, 2, 3] → length 3
  //
  // TC: O(N), SC: O(N)
  // ^ better using hashmap (reverse mathematics)
  public static void better(int arr[], int k) {

    HashMap<Long, Long> preSumMap = new HashMap<>();
    long sum = 0;
    int maxLen = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      // If prefix sum itself is K
      if (sum == k) {
        maxLen = Math.max(maxLen, i + 1);
      }
      // Reverse mathematics:
      // sum - previousSum = k
      // previousSum = sum - k
      long rem = sum - k;
      if (preSumMap.containsKey(rem)) {
        long len = i - preSumMap.get(rem);
        maxLen = Math.max(maxLen, (int) len);
      }
      // Store FIRST occurrence only
      // because we want the longest subarray
      if (!preSumMap.containsKey(sum)) {
        preSumMap.put(sum, (long) i);
      }
    }
    System.out.println(maxLen);
  }

  

  //& optimal using two pointer approch O(2n)
  public static void mine_wasOptimal(int arr[], int k){
    int left=0, right=0, n=arr.length;
    int maxlength =0;
    int sum = arr[0];
    while(right < n){
      while(left<=right && sum>k){
        sum -=arr[left];
        left++;
      }
      if(sum == k){
        maxlength = Math.max(maxlength, right-left+1);
      }
      right++;
      if(right<n)sum += arr[right];
    }
    System.out.println(maxlength);
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 1, 1, 1, 1, 4, 2, 3 };
    mine_wasOptimal(arr, 6);
  }
}

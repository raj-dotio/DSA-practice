package easy;



public class A11_missingNumber {

  //& brute- time: O(n^2) hypothetical scenerio spcae: O(1)
  public static void brute(int arr[]){
    // int flag=0;
    for(int i=0; i<arr.length; i++){
      for(int j=0; j<arr.length; j++){
        // compaing logic too much time taking 
      }
    }
  }


  //& better- time: O(3n) , space: O(n)
  public static void mine_wasBetter(int arr[]){
    int max = Integer.MIN_VALUE;
    for(int val : arr){
      max = Math.max(max, val);
    }
    int hash[] = new int[max+1];
    for(int val : arr){
      hash[val] = 1;
    }
    // System.out.println(Arrays.toString(hash));
    for(int i=1; i<hash.length; i++){
      if(hash[i] !=1){
        System.out.println(i);
        return;
      }
    }
  }

  //& sum_optimal- time: O(n), space: O(1)
  public static void optimal(int arr[]){
    int n = arr.length+1;
    int sum = (n*(n+1))/2;
    int have=0;
    for(int val : arr){
      have += val;
    }
    int missingNum = sum - have;
    System.out.println(missingNum);
  }

  //& XOR_optimal- (better)
  /* XOR concept
    *CONCEPT: XOR (^) operator
    *BASIC RULES:
    0 ^ 0 = 0
    1 ^ 1 = 0
    0 ^ 1 = 1
    1 ^ 0 = 1
    *IMPORTANT PROPERTIES:
    1. a ^ a = 0        // same cancel ho jaata hai
    2. a ^ 0 = a        // identity
    3. commutative      // a ^ b = b ^ a
    4. associative      // (a ^ b) ^ c = a ^ (b ^ c)
    *CORE IDEA:
    "same numbers cancel ho jaate hain"
    *USE CASES:
    *1. Find single element (others twice)
    [2,3,2,4,4] → 3
    logic:
    res = 0
    for each val:
      res ^= val
    2 ^ 3 ^ 2 ^ 4 ^ 4
      = (2 ^ 2) ^ (4 ^ 4) ^ 3
      = 0 ^ 0 ^ 3
      = 3
    *2. Swap without temp
    a = a ^ b
    b = a ^ b
    a = a ^ b
      *Example:
          5 ^ 3
          Step 1: Binary me convert
            5 = 101
            3 = 011
          Step 2: Bitwise XOR
              1 0 1
            ^ 0 1 1
            ---------
              1 1 0
          👉 Result = 110 = 6
    *3. Missing number (0 to n)
    res = XOR(all elements) ^ XOR(0→n)

    *PATTERN:
    bit manipulation / parity
    TIME: O(n) SPACE: O(1)
    *MEMORY LINE:
    "XOR me same number gayab ho jaata hai"
  */
  public static void optimal_XOR(int arr[]){
    int n = arr.length;
    int xor1 = 0;
    // for(int i=1; i<n; i++){
    //   xor1 ^= i;
    // }
    int xor2=0;
    for(int i=0; i<n-1; i++){
      xor2 ^= arr[i];
      xor1 ^= (i+1);
    }
    xor1 ^= n;
    System.out.println(xor1^xor2);
  }

  public static void main(String[] args) {
    int arr[] = {1,2,4,5};
    // mine_wasBetter(arr);
    // optimal(arr);
    optimal_XOR(arr);
  }
}

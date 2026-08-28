import java.util.*;

public class A1_ArrayBasics {
    public static void main(String[] args) {

        // ===== 1. Declaration =====
        int[] arr = new int[5]; 
        // size fixed hota hai, default values = 0

        int[] arr2 = {1, 2, 3, 4, 5}; 
        // direct initialization

        // ===== 2. Access / Update =====
        int x = arr2[2];       // get element (index 2 → 3)
        arr2[2] = 10;          // update

        // ===== 3. Length =====
        int n = arr2.length;   // property hai, function nahi

        // ===== 4. Traversal =====
        // normal loop
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

        // for-each (read-only use karo mostly)
        for (int val : arr2) {
            System.out.print(val + " ");
        }

        // ===== 5. Input (user se) =====
        Scanner sc = new Scanner(System.in);
        int n2 = sc.nextInt();
        int[] arr3 = new int[n2];

        for (int i = 0; i < n2; i++) {
            arr3[i] = sc.nextInt();
        }

        // ===== 6. Sorting =====
        Arrays.sort(arr2); 
        // ascending sort

        // ===== 7. Binary Search =====
        int idx = Arrays.binarySearch(arr2, 4);
        // mil gaya → index
        // nahi mila → negative value (samajhna padega)

        // ===== 8. Max / Min =====
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int val : arr2) {
            if (val > max) max = val;
            if (val < min) min = val;
        }

        // ===== 9. Reverse =====
        int l = 0, r = arr2.length - 1;
        while (l < r) {
            int temp = arr2[l];
            arr2[l] = arr2[r];
            arr2[r] = temp;
            l++; r--;
        }

        // ===== 10. Print array =====
        System.out.println(Arrays.toString(arr2));
        // clean print → [1,2,3]

        // ===== 11. Copy array =====
        int[] copy = Arrays.copyOf(arr2, arr2.length);

        // ===== 12. Fill =====
        Arrays.fill(arr, 7); 
        // sab elements = 7

        // ===== 13. 2D Array =====
        int[][] mat = new int[2][3];

        mat[0][1] = 5;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mat[i][j] + " ");
            }
        }
    }
}

import java.util.Arrays;

public class A10_intersectionOfTwoArrays {


  public static void mine1(int a[], int b[]){
    int n1 = a.length;
    int n2 = b.length;
    int i=0,j=0,k=0;
    int intersect[] = new int[Math.min(n1, n2)];
    while(i<n1 && j<n2){
      if(a[i]==b[j]){
        intersect[k++] = a[i];
        i++; j++; 
      }else if(a[i]<b[j]){
        i++;
      }else{
        j++;
      }
    }
    System.out.println(Arrays.toString(intersect));
  }
  public static void main(String[] args) {
    int arr1[] = {1,1,2,2,3,4,5};
    int arr2[] = {2,2,3,4,4,5};
    mine1(arr1, arr2);
  }
}

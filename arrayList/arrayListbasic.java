import java.util.ArrayList;
import java.util.Collections;

public class arrayListbasic {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    
    // add elements
    list.add(5);
    list.add(4);
    list.add(3);
    System.out.println(list);

    // get element
    System.out.println(list.get(0));

    // add elem in btw .add(index{where u want to add}, value)
    list.add(1, 9);
    System.out.println(list);

    // set elementz
    list.set(2, 10);
    System.out.println(list);

    // remove elment(delete)
    list.remove(2);
    System.out.println(list);

    // size()
    System.out.println(list.size());

    // loops both works (simple forloop) & (enhanced forloop(forEach))
    for (int val : list) {
      System.out.print(val + " ");
    }
    System.out.println();

    // sort
    Collections.sort(list);
    System.out.println(list);
  }
}

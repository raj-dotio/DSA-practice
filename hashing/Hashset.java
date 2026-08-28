import java.util.HashSet;
import java.util.Iterator;


public class Hashset{
  public static void main(String[] args) {

    HashSet<Integer> set = new HashSet<>();
    //insert-  .add()
    set.add(1);
    set.add(2);
    set.add(3);
    set.add(1);
    set.add(1);

    //print- syso(setname) simple print
    System.out.println(set);

    //search- .contains()
    if(set.contains(1)){
      System.out.println("yes it contain 1");
    }

    //delete- .remove()
    set.remove(1);
    System.out.println(set);

    //size - .size()
    System.out.println("no. of elem : "+set.size());

    // Iterator (like loop) // {1. hashnext() , 2. next()}
    Iterator<Integer> it = set.iterator();   
    while(it.hasNext()){
      System.out.println(it.next());
    }
    //instead of itretor we can use enhanced forloop like (for each)
    for(int val: set){
      System.out.println(val);
    }
  }
}
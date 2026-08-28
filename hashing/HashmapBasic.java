// Hash-based collections in Java:
//
// HashMap       → Key + Value, no duplicate keys, no guaranteed order.
// HashSet       → Unique values, no guaranteed order.
//
// LinkedHashMap → Key + Value + insertion order.
// LinkedHashSet → Unique values + insertion order.
//
// TreeMap       → Key + Value + sorted key order.
// TreeSet       → Unique values + sorted order.
//
// HashMap/HashSet → Average O(1)
// TreeMap/TreeSet → O(log N)
//
// Note: HashMap, HashSet etc. are hash-based collection classes,
// not "types of hashing".



import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
CONCEPT: HashMap

MEANING:
key → value pairs store karta hai (unique keys)

EXAMPLE:
{1 → "A", 2 → "B"}

CORE IDEA:
fast lookup, insert, delete using hashing

OPERATIONS:
put(key, value)     → add/update
get(key)            → value return
containsKey(key)    → exist check
remove(key)         → delete

TIME:
O(1) average (fast)

USE CASES:
- frequency count
- duplicates check
- mapping / lookup

MEMORY LINE:
"key se value turant nikaal"
*/

public class HashmapBasic{
  public static void main(String[] args) {
    // create
    HashMap<Integer, String> map = new HashMap<>();

    // put (add/update)
    map.put(1, "A");
    map.put(2, "B");
    map.put(3, "C");
    map.put(2, "BB"); // overwrite

    // get
    System.out.println(map.get(2)); // BB

    // contains
    System.out.println(map.containsKey(3)); // true
    System.out.println(map.containsValue("A")); // true

    // remove
    map.remove(1);

    // size
    System.out.println(map.size());

    // iterate keys
    for (int key : map.keySet()) {
      System.out.println(key);
    }

    // iterate values
    for (String val : map.values()) {
      System.out.println(val);
    }

    // iterate key-value
    for (Map.Entry<Integer, String> e : map.entrySet()) {
        System.out.println(e.getKey() + " -> " + e.getValue());
    }
    //or
    Set<Integer> keys = map.keySet();
    for(Integer key : keys){
      System.out.println(key+ "->" + map.get(key));
    }



    // getOrDefault (important)
    // getOrDefault(key, default)
    //  |            |
    //  |            └── agar key mili NAHI toh yeh do
    //  └── yeh key dhundo map mein
    System.out.println(map.getOrDefault(10, "Not Found"));
    // arr = [3, 5, 3, 3, 5]
//
// Step | arr[i] | Map before      | getOrDefault | After +1 | Map after
// -----|--------|-----------------|--------------|----------|------------------
// i=0  |   3    | {}              | 0 (nahi tha) |    1     | {3:1}
// i=1  |   5    | {3:1}           | 0 (nahi tha) |    1     | {3:1, 5:1}
// i=2  |   3    | {3:1, 5:1}      | 1 (mila!)    |    2     | {3:2, 5:1}
// i=3  |   3    | {3:2, 5:1}      | 2 (mila!)    |    3     | {3:3, 5:1}
// i=4  |   5    | {3:3, 5:1}      | 1 (mila!)    |    2     | {3:3, 5:2}
//
// agar sirf map.get(arr[i]) + 1 likhte toh?
// → pehli baar 3 aaya, map.get(3) = null
// → null + 1 = NullPointerException 💥 ERROR!
//
// isliye getOrDefault(arr[i], 0) use karte hain
// → pehli baar aaya = 0 do, phir +1 = 1 ✅
// → dobara aaya = purani value do, phir +1 ✅

// map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);


    // clear
    map.clear();

    // check empty
    System.out.println(map.isEmpty());

  }
}
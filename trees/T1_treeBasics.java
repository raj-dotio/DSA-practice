package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Node {
  int data;
  Node left, right;

  // ~ constructor
  public Node(int data) {
    this.data = data;
  }
}

public class T1_treeBasics {
  // ! creating Trees
  // ~ constuctor
  Node root;

  public T1_treeBasics() {
    root = new Node(0);
    root.left = new Node(1);
    root.right = new Node(2);
    root.left.left = new Node(3);
    root.left.right = new Node(4);
  }

  public static void main(String[] args) {
    // T1_treeBasics → class/type
    // tree1 → reference variable
    // new T1_treeBasics() → object

    T1_treeBasics tree1 = new T1_treeBasics();
    System.out.println(tree1);

    // preorder(tree1.root);
    // inorder(tree1.root);
    // postorder(tree1.root);

    // System.out.println(levelorder(tree1.root));

    //& itretive orders
    // List<Integer> preorder =  iterativeTraversal.ItretivePreorder(tree1.root);
    // System.out.println(preorder);

    // List<Integer> inorder =  iterativeTraversal.iterativeInorder(tree1.root);
    // System.out.println("inorder : "+inorder);

    List<Integer> postorder =  iterativeTraversal.iterativePostorder(tree1.root);
    System.out.println("postorder : "+postorder);

  }



  // ! DFS -depth first search (preorder , inorder , postorder)
  // ^ preorder treversal (root -> left -> right)
  public static void preorder(Node node) {
    if (node == null)
      return;

    System.out.println(node.data);
    preorder(node.left);
    preorder(node.right);
  }

  // ^ inorder treversal (left -> root -> right)
  public static void inorder(Node node) {
    if (node == null)
      return;

    inorder(node.left);
    System.out.println(node.data);
    inorder(node.right);
  }

  // ^ postorder treversal (left -> right -> root)
  public static void postorder(Node node) {
    if (node == null)
      return;

    postorder(node.left);
    postorder(node.right);
    System.out.println(node.data);
  }

  // ! BFS - breath first search (level order traversal)
  // ^ level by level time : O(n) space : O(n)
  
  public static List<List<Integer>> levelorder(Node root) {
    // offer() → queue mein DAALO
    // peek() → front ko DEKHO, remove MAT karo
    // poll() → front ko NIKAALO means remove bhi ho gya
    // Queue = [2, 3, 4]
    // peek() → 2
    // Queue = [2, 3, 4]
    // poll() → 2
    // Queue = [3, 4]
    // offer(5)
    // Queue = [3, 4, 5]
    Queue<Node> queue = new LinkedList<Node>();
    List<List<Integer>> wraplist = new LinkedList<List<Integer>>();

    if (root == null)
      return wraplist;
    queue.offer(root); // offer() Queue mein element add karta hai.
    while (!queue.isEmpty()) {
      int lvlnum = queue.size();
      List<Integer> sublist = new LinkedList<Integer>();
      for (int i = 0; i < lvlnum; i++) {
        if (queue.peek().left != null)
          queue.offer(queue.peek().left);
        if (queue.peek().right != null)
          queue.offer(queue.peek().right);
        sublist.add(queue.poll().data);
      }
      wraplist.add(sublist);
    }
    return wraplist;
  }

}




// ~~ static ka simple meaning:
// !Jo cheez object ke saath nahi, class ke saath belong karti hai.
// static    → Class se belong
// non-static → Object se belong



class iterativeTraversal {
  //^ Iterative Preorder: Root → Left → Right
  public static List<Integer> iterativePreorder(Node root) {
    // Uses Stack (LIFO) instead of recursion.
    // 1. Push root into stack.
    // 2. Pop top node → visit it.
    // 3. Push Right child.
    // 4. Push Left child. 
    //    (ush it to  answer preorderlist)
    // 5. Repeat until stack is empty.
    // Right is pushed first, Left second → Left is popped first (top of stack).
    // TC: O(N), SC: O(H)
    List<Integer> preorder = new LinkedList<Integer>();
    if(root == null) return preorder;
    
    Stack<Node> stack = new Stack<Node>();
    stack.push(root);
    while(!stack.isEmpty()){
      root = stack.pop();
      preorder.add(root.data);
      if(root.right !=null){
        stack.push(root.right);
      }
      if(root.left !=null){
        stack.push(root.left);
      }
    }
    return preorder;
  }


  //^ Iterative inorder: left → root → Right
  public static List<Integer> iterativeInorder(Node root){
    
    List<Integer> inorder = new LinkedList<Integer>();
    if(root == null) return inorder;

    Stack<Node> stack = new Stack<>();
    Node node = root;
    while(true){
      if(node != null){
        stack.push(node);
        node = node.left;
      }else{
        if(stack.isEmpty()){
          break;
        }
        node = stack.pop();
        inorder.add(node.data);
        node = node.right;
      }
    }

    return inorder;
  }


  //^ Iterative Postorder: left → right → Root 
  //& [using two stacks]
  public static List<Integer> iterativePostorder(Node root){
    List<Integer> postorder = new LinkedList<>();
    if(root == null) return postorder;

    Stack<Node> stack1 = new Stack<Node>();
    Stack<Node> stack2 = new Stack<Node>();
    stack1.push(root);
    while(!stack1.isEmpty()){
      root = stack1.pop();
      stack2.push(root);
      if(root.left != null) stack1.push(root.left);
      if(root.right != null) stack1.push(root.right);
    }
    while(!stack2.isEmpty()){
      postorder.add(stack2.pop().data);
    }
    return postorder;
  }



}
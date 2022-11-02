package JavaFiddle;


  class Node {
      int val;
      Node left;
      Node right;
      Node() {}
      Node(int val) { this.val = val; }
      Node(int val, Node left, Node right) {
          this.val = val;
        this.left = left;
         this.right = right;
    }
}

public class ValidBST {
    public static boolean isValidBST(Node root) {
        return checkNode(root,  -Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public static boolean checkNode(Node ptr, int min, int max){
       if(ptr == null) return true;
       if(ptr.val > min && ptr.val < max)
           return checkNode(ptr.left, min, Math.min(max, ptr.val)) && checkNode(ptr.right, Math.max(min, ptr.val), max);
       else return false;
    }

    public static void main(String[] args) {
        Node
                d = new Node(4),
                e = new Node(7),
                c = new Node(6, d, e),
                b = new Node(1),
                a = new Node(5, b, c);

        System.out.println(isValidBST(a));
    }
}



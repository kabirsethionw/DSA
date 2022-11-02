package JavaFiddle;

import java.util.Stack;

public class VerticalSum {
    class Memo{
        private TreeNode node;
        private int dis;
        Memo(int dis, TreeNode node){
            this.dis = dis;
            this.node = node;
        }
    }

    public int computeVerticalSum(TreeNode root){
        Memo ptr = new Memo(0, root);
        int sum = 0;
        Stack<Memo> stack = new Stack<>();

        while(true){
            if(ptr.node == null && stack.isEmpty()) break;
            while(ptr.node != null){
                stack.push(ptr);
                ptr = new Memo(ptr.dis - 1, ptr.node.left);
            }
            ptr = (Memo)stack.pop();
            if(ptr.dis == 0) sum += ptr.node.val;
            ptr = new Memo(ptr.dis+1, ptr.node.right);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode
                d = new TreeNode(4, null, null),
                e = new TreeNode(5, null, null),
                f = new TreeNode(7, null, null),
                g = new TreeNode(6, null, null),
                b = new TreeNode(2, d, e),
                c = new TreeNode(3, f, g),
                a = new TreeNode(1, b,c);
        System.out.println(new VerticalSum().computeVerticalSum(a));
    }
}

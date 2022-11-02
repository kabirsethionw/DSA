package JavaFiddle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LCAofBinaryTree {
    static ArrayList<ArrayList<TreeNode>> paths = new ArrayList<>();
    static boolean pFound = false, qFound = false;

    static{
        paths.add(null);
        paths.add(null);
    }

    private static void LCAHelper(TreeNode node, TreeNode p, TreeNode q, ArrayList<TreeNode> path) {
        if(node == null) return;
        path.add(node);

        if(node.val == p.val){
            pFound = true;
            paths.add(0, new ArrayList<>(path));
        }
        else if(node.val == q.val){
            qFound = true;
            paths.add(1, new ArrayList<>(path));
        }
        else{
            LCAHelper(node.left, p, q, path);
            if(!(pFound && qFound))
                LCAHelper(node.right, p, q, path);
        }

        path.remove(path.size()-1);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LCAHelper(root, p, q, new ArrayList<>());
        TreeNode ptr1, ptr2;
        int ptr = 0;
        ptr1 = paths.get(0).get(ptr);
        ptr2 = paths.get(1).get(ptr);
        // p - 0, q - 1
        while(ptr1.val == ptr2.val){
            ptr++;
            ptr1 = paths.get(0).get(ptr);
            ptr2 = paths.get(1).get(ptr);
        }

        return paths.get(0).get(ptr-1);
    }

    public static void main(String[] args) {
        TreeNode a, b, c, d, e, f, g, h, i, j;
        a = new TreeNode(1);
        b = new TreeNode(2); a.left = b;
        c = new TreeNode(3); a.right = c;
        d = new TreeNode(4); b.left = d;
        e =new TreeNode(5); b.right = e;
        f = new TreeNode(6); e.left = f;
        g = new TreeNode(7); e.right = g;
        h = new TreeNode(8); f.left = h;
        i = new TreeNode(9); g.right = i;
        j = new TreeNode(10); i.right = j;
        System.out.println(lowestCommonAncestor(a, h, j).val);
    }
}

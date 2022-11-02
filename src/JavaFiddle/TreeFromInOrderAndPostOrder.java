package JavaFiddle;


//{ Driver Code Starts
import java.util.*;

class MyNode {
    int data;
    MyNode left;
    MyNode right;

    MyNode(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class TreeFromInOrderAndPostOrder {
    public void preOrder(MyNode root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        TreeFromInOrderAndPostOrder ip = new TreeFromInOrderAndPostOrder();

        int
            n = 8,
            in[] = {4, 8, 2, 5, 1, 6, 3, 7},
            post[] = {8, 4, 5, 2, 6, 7, 3, 1};
        GfG g = new GfG();
        MyNode root = g.buildTree(in, post, n);
        ip.preOrder(root);

    }
}

// } Driver Code Ends


/* Tree node structure
class MyNode
{
    int data;
    MyNode left;
    MyNode right;

        MyNode(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    public static int search(int[] array, int key) {
        int returnvalue = -1;
        for (int i = 0; i < array.length; ++i) {
            if (key == array[i]) {
                returnvalue = i;
                break;
            }
        }
        return returnvalue;
    }

    //Function to return a tree created from postorder and inoreder traversals.
    MyNode buildTree(int in[], int post[], int n) {
        // Your code here
        return helper(post, in, 0, in.length-1, 0, post.length-1);
    }

    private static MyNode helper(int[] post, int[] in, int inStart, int inEnd, int postStart, int postEnd){
        MyNode node = null, left = null, right = null;
        //System.out.println(inStart + "-"+ inEnd + ", "+postStart+"-"+postEnd);
        if(inStart == inEnd) node = new MyNode(in[inStart]);
        else{
            int
                    postMyNode = postEnd,
                    inMyNode = search(in, post[postMyNode]),
                    lLen = inMyNode - inStart,
                    rLen = inEnd - inMyNode,
                    inls = inStart, inle = inMyNode-1, inrs = inMyNode+1, inre = inEnd,
                    postls = postStart, postle = postStart+lLen-1, postrs = postEnd-rLen,
                    postre = postEnd-1;

            if(inls <= inle) left = helper(post, in, inls, inle, postls, postle);
            else left = null;

            if(inrs <= inre) right = helper(post, in, inrs, inre, postrs, postre);
            else right = null;

            node = new MyNode(post[postEnd]);
            node.left = left;
            node.right = right;
        }
        return node;
    }
}


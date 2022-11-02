package JavaFiddle;

//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class MyMyNode{
    int data;
    MyNode left;
    MyNode right;
    MyMyNode(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class LeavesOfDLL {

    static MyNode buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        MyNode root = new MyNode(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<MyNode> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            MyNode currMyNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currMyNode.left = new MyNode(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currMyNode.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N")) {

                // Create the right child for the current node
                currMyNode.right = new MyNode(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currMyNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(MyNode root){
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            String s = br.readLine();
            MyNode root = buildTree(s);
            Tree g = new Tree();
            MyNode head = g.convertToDLL(root);
            printInorder(root);
            System.out.println();
            MyNode curr = head;
            MyNode last = head;
            while(curr!=null){
                System.out.print(curr.data+" ");
                last = curr;
                curr = curr.right;
            }
            System.out.println();
            curr = last;
            while(curr!=null){
                System.out.print(curr.data+" ");
                curr = curr.left;
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
MyNode is as follows:
class MyNode{
    int data;
    MyNode left;
    MyNode right;
    MyNode(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Tree{
    private static MyNode head;
    private static MyNode prev;

    private static boolean isLeaf(MyNode node){
        return node != null && node.left == null && node.right == null;
    }

    private static void helper(MyNode node){
        if(node != null){
            if(isLeaf(node)){
                if(head == null) head = node;
                if(prev != null){
                    prev.right = node;
                    node.left = prev;
                }
                prev = node;
            }
            else{
                boolean
                        lLeaf = isLeaf(node.left),
                        rLeaf = isLeaf(node.right);

                helper(node.left);
                helper(node.right);
                if(lLeaf) node.left = null;
                if(rLeaf) node.right = null;
            }
        }
    }

    // return the head of the DLL and remove those node from the tree as well.
    public MyNode convertToDLL(MyNode root)
    {
        // Code here
        helper(root);
        MyNode res = head;
        head = null;
        prev = null;
        return res;
    }

}


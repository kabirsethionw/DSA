package JavaFiddle;



public class MaximumPathSumFromLeafToLeafOfBinaryTree {

    public class TNode {
        int data;
        TNode left;
        TNode right;

        TNode() {
        }

        TNode(int data) {
            this.data = data;
        }

        TNode(int data, TNode left, TNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    int maxPathSum(TNode root)
    {
        int ans = helper_node_to_leaf_return(root);
        if(root.left == null || root.right == null){
            return Math.max(leaftoleafmax,ans);
        }
        return leaftoleafmax;
    }
    public int leaftoleafmax = -(int)1e9;
    public int helper_node_to_leaf_return(TNode root){
        if(root == null) return -(int)1e9;
        if(root.left == null && root.right == null){
            return root.data;
        }
        int left_node_to_leaf = helper_node_to_leaf_return(root.left);
        int right_node_to_leaf = helper_node_to_leaf_return(root.right);
        if(root.left != null && root.right!=null){
            leaftoleafmax = Math.max(leaftoleafmax , left_node_to_leaf + root.data + right_node_to_leaf);
        }
        return Math.max(left_node_to_leaf,right_node_to_leaf) + root.data ;
    }
}

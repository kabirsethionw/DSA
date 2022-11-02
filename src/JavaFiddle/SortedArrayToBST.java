package JavaFiddle;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class SortedArrayToBST {
    public static TreeNode solution(int[] arr){
        return generateNode(arr, 0, arr.length-1);
    }

    private static TreeNode generateNode(int[] arr, int l, int r){
        if(l == r) return new TreeNode(arr[l]);
        int mid = (l+r)/2; TreeNode n = new TreeNode(arr[mid]);
        n.left = mid == l ? null : generateNode(arr, l, mid-1);
        n.right = mid == r ? null : generateNode(arr, mid+1, r);
        return n;
    }

    public static void main(String[] args) {
        int testArr[] = {-10,-3,0,5,9};
        TreeNode res = solution(testArr);
        System.out.println(res); //Check through debugger
    }
}

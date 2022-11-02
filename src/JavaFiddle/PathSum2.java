package JavaFiddle;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    private List<List<Integer>> res = new ArrayList<List<Integer>> ();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        findPath(new ArrayList<Integer>(), root, targetSum, 0);
        return res;
    }

    private void findPath(List<Integer> localList, TreeNode node, int targetSum, int sum){
        if(node != null){
            localList.add(node.val);
            sum += node.val;

            if(node.left == null && node.right == null){
                if(sum  == targetSum){
                    res.add(localList);
                    System.out.println(sum);
                }
            }else{
                List<Integer>
                        localList1 = deepClone(localList),
                        localList2 = deepClone(localList);

                findPath(localList1, node.left, targetSum, sum);
                findPath(localList2, node.right, targetSum, sum);
            }
        }

    }

    private static List<Integer> deepClone(List<Integer> list){
        List<Integer> copy = new ArrayList<>();
        list.forEach(elem -> {
            copy.add(elem);
        });
        return copy;
    }
}

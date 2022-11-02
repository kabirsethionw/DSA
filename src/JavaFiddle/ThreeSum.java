package JavaFiddle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        for(int i = 0; i < n-2; i++){
            if(i > 0 && nums[i-1] == nums[i]) continue;
            List<List<Integer>> entries = twoSum(nums, nums[i], i + 1, n - 1);
            res.addAll(entries);
        }
        return res;
    }

    private static List<List<Integer>> twoSum(int[] nums, int target, int start, int end) {
        List<List<Integer>> list = new ArrayList();
        int left = start, right = end;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == -target){
                List<Integer> entry = new ArrayList();
                entry.add(target);
                entry.add(nums[left]);
                entry.add(nums[right]);
                list.add(entry);
                left++; right--;
            }
            else if(sum < target) left++;
            else right--;
        }
        return list;
    }

    public static void main(String[] args) {
        int testArr[] = {-1,0,1,2,-1,-4};
        threeSum(testArr);
    }
}
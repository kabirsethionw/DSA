package JavaFiddle;

import java.util.Arrays;
//Gives timout for large test cases
class Solution {

    private static int dp[];
    private static int maxLen;

    private static int computeLen(int nums[], int pos, boolean isLDS){
        if(dp[pos] != -1) return dp[pos];
        if(nums.length == 1) {maxLen = 1; return 1;};
        if(pos == nums.length -1){
            dp[pos] = 1;
            return dp[pos];
        }
        int max = 1;
        for(int i = pos + 1; i < nums.length; i++){
            boolean con = isLDS ? nums[pos] > nums[i] : nums[pos] < nums[i];
            if(con){
                max = Math.max(max, computeLen(nums, i, isLDS) + 1);
                maxLen = Math.max(maxLen, max);
            }
            else{
                maxLen = Math.max(maxLen, computeLen(nums, i, isLDS));
            }
        }
        dp[pos] = max;
        return max;
    }

    public static int LIS(int nums[], boolean isLDS){
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        computeLen(nums, 0, isLDS);
        int res = maxLen;
        maxLen = 0;
        return res;
    }

    public static int minimumMountainRemovals(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            int lis = 0, lds = 0;
            System.out.println("["+0+"-"+(i+1)+"], ["+(i+1)+"-"+nums.length+"]");
            lis = LIS(Arrays.copyOfRange(nums, 0, i + 1), false);
            if(i < nums.length -1) lds = LIS(Arrays.copyOfRange(nums, i, nums.length), true);
            if(lis > 1 && lds > 1)
                max = Math.max(max, lis + lds - 1);

            System.out.println("lis - "+lis+", lds - "+lds);

        }
        return nums.length - max;
    }

    public static void main(String[] args) {
        int test[] = {1,2,3,4,4,3,2,1};
        System.out.println(minimumMountainRemovals(test));
    }
}
package JavaFiddle;

import java.util.Arrays;

public class LIS_Memoisation {
    private static int dp[];
    private static int maxLen;

    private static int computeLen(int nums[], int pos){
        if(dp[pos] != -1) return dp[pos];
        if(nums.length == 1) return 1;
        if(pos == nums.length - 1) {
            dp[pos] = 1;
            return dp[pos];
        }
        int max = 1;
        for(int i = pos + 1; i < nums.length; i++){
            if(nums[pos] < nums[i]){
                max = Math.max(max, computeLen(nums, i) + 1);
                maxLen = Math.max(maxLen, max);
            }
            else{
                maxLen = Math.max(maxLen, computeLen(nums, i));
            }
        }
        dp[pos] = max;
        return max;
    }

    public static int LIS(int nums[]){
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        computeLen(nums, 0);
        int res = maxLen;
        maxLen = 0;
        return res;
    }


    public static void main(String[] args) {
        int testArr[] = {1,2};
        System.out.println(LIS(testArr));
    }
}

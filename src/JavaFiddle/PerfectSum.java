package JavaFiddle;

import java.util.Arrays;

public class PerfectSum {
    private static int ways = 0;

    /**
     * @description Back-tracking
     * @param n
     * @param arr
     * @param target
     * @return
     */
    public static int getPerfectSum(int n, int[] arr, int target){
        Arrays.sort(arr);
        countWays(arr, 0, target);
        int res = ways;
        ways = 0;
        return res;
    }

    public static int getPerfectSum2(int n, int[] arr, int target){
        int dp[][] = new int[n+1][target+1], count = 1;
        Arrays.sort(arr);
        dp[0][0] = 1;

        for(int i = 1; i < n+1; i++){
            for(int j = 0; j < target + 1; j++){
                if(i > 1 && arr[i-2] == arr[i-1]) count++;
                else count = 1;
                dp[i][j] += dp[i-1][j];
                if(dp[i-1][j] > 0 && j + count*arr[i-1] <= target){
                    dp[i][j+arr[i-1]] += dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }

    private static void countWays(int[] arr, int index, int sum){
        if(sum == 0){ ways++; return;};
        if(index == arr.length || sum < 0) return;
        // We either include or exclude current element
        int end = index; // first element which is not same as arr[int]
        while(end < arr.length && arr[end] == arr[index]){
            end++;
        }
        // When current element is excluded
        countWays(arr, end, sum);

        // To make sure that all the combinations for same values are repeated once
        int count = 0;
        while(count++ < end - index){
            countWays(arr, end, sum - count*arr[index]);
        }
    }

    public static void main(String[] args) {
        int testArr[] = {4,3,2,1,7,7,8}, target = 15;
        System.out.println(getPerfectSum2(testArr.length, testArr, target));

    }
}

package JavaFiddle;

import java.util.Arrays;

public class LongestPerformanceStreak {
    private static int dp[][];
    private static int max = 0;

    private static int getLongestStreak(int[] hours, int n){
        int streak[] = new int[n], l = 0, r = 1, balance = 0, max = 0;
        for(int i = 0; i < n; i++){
            streak[i] = hours[i] > 8 ? 1 : -1;
        }
        balance = streak[0] + streak[1];
        while(r < n && l < n){
            if(balance > 0){
                max = Math.max(max, r-l + 1);
                r++;
                balance += streak[r];
            }
            else {
                balance -= streak[l];
                l++;
            }
        }
        return max;
    }

    private static int getLongestStreakV2(int[] hours, int n){
        int streak[] = new int[n];
        for(int i = 0; i < n; i++){
            streak[i] = hours[i] > 8 ? 1 : -1;
        }
        dp = new int[n][n];
        for(int[] row: dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        helper(0, n-1, streak);
        return max;
    }

    private static int helper(int l, int r, int[] arr){
        if(dp[l][r] != Integer.MAX_VALUE){
            return dp[l][r];
        }

        if(l == r) {
            dp[l][r] = arr[l];
        }
        else if(r == l + 1) {
            dp[l][r] = arr[l] + arr[r];
        }
        else{
            for(int i = l + 1; i < r; i++){
                int left = helper(l, i, arr);
                int right = helper(i, r, arr);
                dp[l][r] = left + right - arr[i];
            }
        }

        if(dp[l][r] > 0)
            max = Math.max(max, r - l + 1);
        return dp[l][r];
    }

    public static void main(String[] args) {
        int[] testArr = {7,9,9,6,0,6,9};
        // -1 1 1 -1 -1 -1 1
        System.out.println(getLongestStreakV2(testArr, testArr.length));
        System.out.println(" ");
    }
}

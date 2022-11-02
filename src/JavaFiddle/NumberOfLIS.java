package JavaFiddle;

import java.util.Arrays;

public class NumberOfLIS {
    private static int getLisCount(int[] arr){
        int dp[] = new int [arr.length];
        int ans = 0, max = -Integer.MAX_VALUE;
        Arrays.fill(dp, 1);
        for(int i = 1; i < arr.length; i++){
            int start = 0, end = i;
            while(start < end){
                if(arr[start] < arr[end]){
                    dp[end] = Math.max(dp[end], dp[start] + 1);
                    if(dp[end] > max){
                        max = dp[end];
                        ans = 1;
                    }
                    else if(dp[end] == max) ans++;
                }
                start++;
            }
        }
        for(int elem: dp) System.out.print(" "+elem);
        return ans;
    }

    public static void main(String[] args) {
        int test[] = {1,3,5,4,7};
        System.out.println("\n ans: " +getLisCount(test));
    }
}

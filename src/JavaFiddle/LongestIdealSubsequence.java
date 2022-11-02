package JavaFiddle;

import java.util.Arrays;

public class LongestIdealSubsequence {
    public static int solution(String s, int k){
        int n = s.length(), dp[] = new int[n], maxLen = 1;
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                int diff = Math.abs(s.charAt(i) - s.charAt(j));
                if(diff <= k){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        return maxLen;
    }

    public static int solutionV2(String s, int k){
        int n = s.length(), dp[] = new int[150], max = 1;
        for(int i = 0; i < n; i++){
            dp[s.charAt(i)] = 1;
        }
        for(int i = 0; i < n; i++){
            int ptr = s.charAt(i);
            int temp = dp[ptr];
            for(int j = ptr - k; j <= ptr + k; j++){
                dp[ptr] = Math.max(dp[j], temp);
                max = Math.max(max, ++dp[ptr]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String test = "acfgdb";
        System.out.println(solutionV2(test, 2));
    }
}

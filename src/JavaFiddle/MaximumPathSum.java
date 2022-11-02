package JavaFiddle;

import java.util.Arrays;

public class MaximumPathSum {
    public static int solution(int[][] mat){
        int n = mat.length, dp[][] = new int[n][n];
        for(int i = 0; i < n; i++) dp[0][i] = mat[0][i];
        for(int i = 1; i < n; i++)
            for(int j = 0; j < n; j++){
                if(j > 0 && j < n-1){
                    dp[i][j] = mat[i][j] + Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i-1][j+1]));
                }
                else if(j == 0){
                    dp[i][j] = mat[i][j] + Math.max(dp[i-1][j], dp[i-1][j+1]);
                }
                else if(j == n-1){
                    dp[i][j] = mat[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        return Arrays.stream(dp[n-1]).max().getAsInt();
    }

    public static void main(String[] args) {
        int[][] testMat = {
                {1,4,2},
                {2,2,2},
                {3,1,3}
        };
        System.out.println(solution(testMat));
    }
}

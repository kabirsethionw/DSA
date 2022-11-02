package JavaFiddle;

public class DistinctSubSequences {
    public static int getDistinctSubsequences(String s, String t){
        int
                n = s.length()+1,
                m = t.length()+1,
                dp[][] = new int[m][n];
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(t.charAt(i-1) == s.charAt(j-1)) dp[i][j] = dp[i][j-1] + dp[i-1][j];
                else dp[i][j] = dp[i][j-1];
            }
        }
        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        String testS = "babgbag", testT = "bag";
        System.out.println(getDistinctSubsequences(testS, testT));
    }
}

package JavaFiddle;

public class Solution2 {
    public static void main(String[] args) {
        int n = 6;
        int k = 3;
        int diff = 0;
        int MOD = 1000000007;
        String str = "dabcde";
        int[][] dp = new int[n+1][k+1];

        for(int i=0;i<=n;i++) {
            for(int j =0;j<=k;j++){
                dp[i][j] = 0;
            }
        }
        dp[0][0]=1;
        for(int i=0;i<n;i++) {
            diff = str.charAt(i) - 'a';
            dp[i][0] =1;
            for(int j =0;j<k;j++){
                if(j!=0)
                    diff = 25;
                dp[i+1][j+1] += ((dp[i][j] * (long)diff)%MOD + dp[i][j+1])%MOD;
                System.out.println(dp[i+1][j+1]+" "+dp[i][j] * diff);
            }
        }
        System.out.println(dp[n][k]);
    }


}

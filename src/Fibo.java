public class Fibo {
    public static int find(int n){
        int dp[] = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        if(n == 1 || n == 2) return n - 1;
        for(int i = 2; i < n; i++){
            dp[i] = dp[i-1] + dp[i -2]; // dp[3] = dp[2] + dp[1] for i = 3 AND dp[2] = dp[1] + dp[0] for i = 3
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(find(7));
    }
}

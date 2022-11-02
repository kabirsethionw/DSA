package JavaFiddle;

public class NoOfWaysToClimbStairs {
    public static int solution(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i = 0; i < n; i++){
            if(i+1 < n+1)
                dp[i+1] += dp[i];
            if(i+2 < n+1)
                dp[i+2] += dp[i];
            if(i+3 < n+1)
                dp[i+3] += dp[i];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int test = 3;
        System.out.println(solution(test));
    }
}





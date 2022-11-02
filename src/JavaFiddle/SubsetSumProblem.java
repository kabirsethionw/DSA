package JavaFiddle;

public class SubsetSumProblem {
    public static boolean solution(int sum, int arr[]){
        boolean dp[][] = new boolean[arr.length][sum+1];
        for(int i = 0; i < arr.length; i++) dp[i][0] = true;
        for(int i = 1; i < arr.length; i++)
            for(int j = 1; j < sum+1; j++){
                if(arr[i] <= j){
                    dp[i][j] = dp[i-1][j - arr[i]] || dp[i-1][j];
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        return dp[arr.length-1][sum];
    }

    public static void main(String[] args) {
        int testArr[] = {3,34,4,12,5,2};
        System.out.println(solution(13, testArr));
    }
}

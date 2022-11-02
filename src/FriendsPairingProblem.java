package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FriendsPairingProblem {
    private static int findWays(int friends){
        int dp[] = new int[friends + 1];
        for(int i = 0; i < dp.length; i++){
            if(i < 3) dp[i] = i;
            else dp[i] = dp[i-1] + (i-1)*dp[i-2];
        }
        return dp[friends];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of friends.");
        System.out.println(findWays(Integer.parseInt(br.readLine())));
    }
}


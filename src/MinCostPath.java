package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinCostPath {

    private static int minCostPath(int[][] cost, int x, int y){
        int m = x + 1, n = y + 1, dp[][] = new int[m][n];
        dp[0][0] = cost[0][0];
        for(int i = 1; i < m; i++){
            dp[i][0] = cost[i][0] + dp[i-1][0];
        }
        for(int i = 1; i < n; i++){
            dp[0][i] = cost[0][i] + dp[0][i-1];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = cost[i][j] + Math.min(dp[i-1][j-1], Math.min(dp[i][i-1], dp[i-1][j]));
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int m, n, x, y, cost[][];
        System.out.println("Enter the dimension of cost Matrix(m x n):");
        line = br.readLine();
        m = Integer.parseInt(line.split(" ")[0]);
        n = Integer.parseInt(line.split(" ")[1]);
        System.out.println("Enter each row of the matrix(" + n + " integers separated by space):");
        cost = new int[m][n];
        for(int i = 0; i < m; i++){
            line = br.readLine();
            String[] temp = line.split(" ");
            cost[i] = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println("Enter the point you want to find cost for:");
        line = br.readLine();
        x = Integer.parseInt(line.split(" ")[0]);
        y = Integer.parseInt(line.split(" ")[1]);
        System.out.println("Answer: " + minCostPath(cost, x, y));
    }
}

package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoldMineProblem {
    private static int findMaxGold(int goldMine[][]) {
        int
                m = goldMine.length,
                n = goldMine[0].length,
                dp[][] = new int[m][n];
        for(int j = n-1; j >=0; j--){
            for(int i = 0; i < m; i++){
                if(j == n-1){
                    dp[i][j] = goldMine[i][j];
                }
                else if(i == 0){
                    dp[i][j] = goldMine[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);
                }
                else if(i == m-1){
                    dp[i][j] = goldMine[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);
                }
                else{
                    dp[i][j] = goldMine[i][j] + findMax(dp[i-1][j+1], dp[i][j+1], dp[i+1][j+1]);
                }
            }
        }
        List<Integer> finalColumn = new ArrayList<Integer>();
        for(int i = 0; i < m; i++){
            finalColumn.add(dp[i][0]);
        }
        Integer maxGold = Collections.max(finalColumn);
        return maxGold.intValue();
    }

    private static int findMax(int num1,int num2, int num3) {
        return Math.max(num1 , Math.max(num2, num3));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of rows.");
        int m = Integer.parseInt(br.readLine());
        System.out.println("Enter number of columns.");
        int n = Integer.parseInt(br.readLine());
        int goldMine[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            System.out.println("Enter numbers for row" + (i + 1) +".");
            String row[] = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                goldMine[i][j] = Integer.parseInt(row[j]);
            }
        }
        System.out.println("Max Gold: " + findMaxGold(goldMine));
        br.close();
    }
}

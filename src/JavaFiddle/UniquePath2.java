package JavaFiddle;

public class UniquePath2 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int
                m = obstacleGrid.length,
                n = obstacleGrid[0].length,
                dp[][] = new int[m][n];
        explorePaths(dp, obstacleGrid, 0, 0);
        return dp[m-1][n-1];
    }

    private static void explorePaths(int[][] dp, int[][] input, int i, int j){
        if(i < 0 || i == input.length || j < 0 || j == input[0].length) return;
        if(input[i][j] == 1) return;
        dp[i][j]++;
        explorePaths(dp, input, i + 1, j);
        explorePaths(dp, input, i, j + 1);
    }

    public static void main(String[] args) {
        int testMat[][] = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(testMat));
    }
}

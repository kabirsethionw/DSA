package JavaFiddle;

public class MaximumSquare {
    public static int maximalSquare(char[][] matrix) {
        int dp[] = new int[matrix[0].length], n = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                dp[j] = Character.getNumericValue(matrix[i][j]) != 0 ? dp[j]+1 : 0;
            }
            int dim[] = new MaxRectangleAreaInHistogram().customLargestRectangleArea(dp);
            n = Math.max(Math.min(dim[0], dim[1]), n);
        }
        return n*n;
    }

    public static void main(String[] args) {
        char testMatrix[][] = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(testMatrix));
    }
}

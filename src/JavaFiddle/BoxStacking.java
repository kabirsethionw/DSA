package JavaFiddle;

import java.util.Arrays;

public class BoxStacking {

    public static int getMaxHeight(int n, int height[], int width[],int length[]){
        int
                dimensions[][] = getDimensionMatrix(height, width, length),
                m = dimensions.length,
                dp[] = new int[m];

        Arrays.sort(dimensions, (t1,t2) -> t2[0] + t2[1] - t1[0] - t1[1]);

        for(int i = 0; i < m; i++) dp[i] = dimensions[i][2];

        for(int i = 1; i < m; i++){
            for(int j = 0; j < i; j++){
                if(dimensions[i][0] < dimensions[j][0] && dimensions[i][1] < dimensions[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + dimensions[i][2]);
                }
            }
        }

        return dp[m-1];
    }

    private static int[][] getDimensionMatrix(int height[], int width[],int length[]){
        int
                n = height.length,
                dimensions[][] = new int[6*n][3];

        for(int i = 0; i < n*6; ){
            int j = i/6;
            dimensions[i] = new int[]{height[j], width[j], length[j]}; i++;
            dimensions[i] = new int[]{height[j], length[j], width[j]}; i++;
            dimensions[i] = new int[]{length[j], height[j], width[j]}; i++;
            dimensions[i] = new int[]{length[j], width[j], height[j]}; i++;
            dimensions[i] = new int[]{width[j], length[j], height[j]}; i++;
            dimensions[i] = new int[]{width[j], height[j], length[j]}; i++;
        }

        return dimensions;
    }

    public static void main(String[] args) {
        int
                n = 3,
                height[] = {1,4,3},
                width[] = {2,5,4},
                length[] = {3,6,1};
        System.out.println(getMaxHeight(n, height, width, length));
    }
}

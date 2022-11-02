package JavaFiddle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test987 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int
                m = matrix.length,
                n = matrix[0].length;

        int l = 0, r = n-1, t = 0, b = m-1;
        List<Integer> list = new ArrayList<>();

        while(l <= r && t <= b){
            if(l == r){
                for(int j = t; j <= b; j++){
                    list.add(matrix[j][l]);
                }
            }
            else if(t == b){
                for(int i = l; i <= r; i++){
                    list.add(matrix[t][i]);
                }
            }
            else{
                for(int i = l; i < r; i++){
                    list.add(matrix[t][i]);
                }

                for(int j = t; j < b; j++){
                    list.add(matrix[j][r]);
                }

                for(int i = r; i > l; i--){
                    list.add(matrix[b][i]);
                }

                for(int j = b; j > t; j--){
                    list.add(matrix[j][l]);
                }
            }

            //if(l == r && t == b) list.add(matrix[t][l]);


            l++; r--; t++; b--;
            //System.out.println(l + " " + r + " " + t + " " + b);
        }

        return list;
    }

    public static void main(String[] args) {
        int testMat[][] = {{2}};
        spiralOrder(testMat);

    }
}

package JavaFiddle;

import java.util.List;

public class NQueens {
    public static int solveNQueens(int n) {
        int dp[][] = new int[n][n];
        placeQueen(dp, 0, n);
        return counter;
    }

    private static int counter = 0;

    private static void placeQueen(int dp[][], int column, int n){
        if(column < n)
            for(int i = 0; i < dp.length; i++){
                if(dp[i][column] != 1){
                    int[][] dpcpy = copy2DArray(dp);
                    dpcpy[i][column] = 2;
                    drawPath(dpcpy, column, i);
                    placeQueen(dpcpy, column + 1, n);
                }
            }
        else counter++;
    }

    private static void drawPath(int board[][], int x, int y){
        int
                count = 1,
                uy[] = {0, -1},
                ly[] = {0, 1},
                lx[] = {-1, 0},
                rx[] = {1, 0},
                uld[] = {-1, -1},
                urd[] = {1, -1},
                lld[] = {-1, 1},
                lrd[] = {1, 1};

        boolean con = false, uycon, lycon, lxcon, rxcon, uldcon, urdcon, lldcon, lrdcon;

        do{
            uycon = conCheck(board, uy[0]*count + x, uy[1]*count + y);
            lycon = conCheck(board, ly[0]*count + x, ly[1]*count + y);
            lxcon = conCheck(board, lx[0]*count + x, lx[1]*count + y);
            rxcon = conCheck(board, rx[0]*count + x, rx[1]*count + y);
            uldcon = conCheck(board, uld[0]*count + x, uld[1]*count + y);
            urdcon = conCheck(board, urd[0]*count + x, urd[1]*count + y);
            lldcon = conCheck(board, lld[0]*count + x, lld[1]*count + y);
            lrdcon = conCheck(board, lrd[0]*count + x, lrd[1]*count + y);
            if(uycon) board[uy[1]*count + y][uy[0]*count + x] = 1;
            if(lycon) board[ly[1]*count + y][ly[0]*count + x] = 1;
            if(lxcon) board[lx[1]*count + y][lx[0]*count + x] = 1;
            if(rxcon) board[rx[1]*count + y][rx[0]*count + x] = 1;
            if(uldcon) board[uld[1]*count + y][uld[0]*count + x] = 1;
            if(urdcon) board[urd[1]*count + y][urd[0]*count + x] = 1;
            if(lldcon) board[lld[1]*count + y][lld[0]*count + x] = 1;
            if(lrdcon) board[lrd[1]*count + y][lrd[0]*count + x] = 1;
            con = uycon || lycon || lxcon || rxcon || uldcon || urdcon || lldcon || lrdcon;
            count++;

        }while (con);
    }

    private static boolean conCheck(int arr[][], int x, int y){
        return y > -1 && y < arr.length && x > -1 && x < arr[0].length;
    }

    private static int[][] copy2DArray(int[][] array){
        int clonedArray[][] = new int[array.length][array[0].length];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                clonedArray[i][j] = array[i][j];
            }
        }
        return clonedArray;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}

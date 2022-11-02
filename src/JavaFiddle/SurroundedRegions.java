package JavaFiddle;

public class SurroundedRegions {
    private static char[][] result = null;
    private static boolean updated = false;

    private static char[][] solutionHelper(char[][] board, int x, int y){
        if(board[x][y] == 'o'){
            boolean
                    xCondition = x>0 && x < board[0].length,
                    yCondition = y>0 && y < board.length,
                    isBaseCase = board[x-1][y] =='x' && board[x+1][y] =='x' && board[x][y-1] =='x' && board[x][y+1] == 'x';

            if(xCondition && yCondition){
                if(isBaseCase){
                    board[x][y] = 'x';
                    arrayCopy(board, result);
                    updated = true;
                }
                board[x][y] = 'x';
                solutionHelper(board, x+1, y);
                solutionHelper(board, x, y+1);
                solutionHelper(board, x-1, y);
                solutionHelper(board, x, y-1);
                board[x][y] = 'o';
            }
            else return null;
        }
        return null;
    }

    public static char[][] solution(char[][] board){
        if(board.length <= 2 || board[0].length <= 2) return board;
        result = new char[board[0].length][board.length];
        for(int i = 1; i < board[0].length-1; i++){
            for (int j = 1; j < board.length-1; j++){
                solutionHelper(board, i, j);
                if(updated){
                    arrayCopy(result, board);
                    updated = false;
                }
            }
        }
        return  result;
    }

    public static void arrayCopy(char[][] aSource, char[][] aDestination) {
        for (int i = 0; i < aSource.length; i++) {
            System.arraycopy(aSource[i], 0, aDestination[i], 0, aSource[i].length);
        }
    }

    public static void main(String[] args) {
        char[][] testMat = {
                {'x','x','x','o'},
                {'x','o','o','x'},
                {'x','x','o','x'},
                {'x','o','x','x'}
        };
        solution(testMat);
        for(int i = 0 ; i < testMat.length;i++ ){
            for(int j = 0 ; j < testMat[0].length;j++ ){
                System.out.print(result[i][j]+ " ");
            }
            System.out.print("\n");
        }
    }
}

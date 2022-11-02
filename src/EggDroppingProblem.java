public class EggDroppingProblem {
    public static int countMoves(int floors, int eggs){
        int dp[][] = new int[eggs + 1][floors + 1], count = 0;
        for(int elem: dp[0]) elem = 0; // 0 moves for 0 eggs
        for(int elem: dp[1]) elem = count++; // base case, for 1 egg and n floors there are at worst n moves
        for(int i = 2; i < eggs + 1; i++) dp[i][0] = 0; // for zero floors there are 0 moves

        for(int e = 2; e <= eggs; e++)
            for(int f = 1; f <= floors; f++){ // computing sub problems
                dp[e][f] = Integer.MAX_VALUE;
                for(int i = 1; i <= f; i++){ // for given f floors we try for 1-f floors;
                    int val = Math.max(dp[e-1][i-1], dp[e][f-i]);
                    if(val < dp[e][f]) dp[e][f] = val; // which of the floor when tried dropping eggs from, yields min moves is saved.
                }
            }

        return dp[eggs][floors];
    }

    public static void main(String[] args) {
        System.out.println(countMoves(6, 3));
    }
}

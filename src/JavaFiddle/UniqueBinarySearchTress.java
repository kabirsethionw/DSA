package JavaFiddle;

import java.util.HashMap;

public class UniqueBinarySearchTress {
    private static HashMap<Integer, Integer> dp = new HashMap<>();

    public static int findUniqueTrees(int n){
        if(dp.get(n) != null) return dp.get(n);
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;
        int ways = 0;
        for(int r = 1; r <= n; r++)
            ways += findUniqueTrees(r-1)*findUniqueTrees(n-r);
        dp.put(n, ways);
        return ways;
    }

    public static void main(String[] args) {
        int test = 4;
        System.out.println(findUniqueTrees(test));
    }
}

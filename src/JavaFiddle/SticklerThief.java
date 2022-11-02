package JavaFiddle;

public class SticklerThief {
    public static int getMaxLoot(int[] houses){
        int
                n = houses.length,
                dp[] = new int[n];
        if(houses.length == 0) return 0;
        if(houses.length == 1) return houses[0];
        if(houses.length == 2) return Math.max(houses[0], houses[1]);
        dp[0] = houses[0];
        dp[1] = houses[1];
        dp[2] = houses[0] + houses[2];
        for(int i = 3; i < n; i++){
            dp[i] = houses[i] + Math.max(dp[i-2], dp[i-3]);
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        int testArr[] = {5,5,10,100,10,5};
        System.out.println(getMaxLoot(testArr));
    }
}

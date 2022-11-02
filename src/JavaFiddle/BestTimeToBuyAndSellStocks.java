package JavaFiddle;

public class TestMNO {


    public static int maxProfit(int[] prices){
        int
                n = prices.length,
                dpMin[] = new int[n],
                dpMax[] = new int[n];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(min, prices[i]);
            dpMin[i] = min;
        }
        for(int i = n-1; i > -1; i--){
            max = Math.max(max, prices[i]);
            dpMax[i] = max;
        }

        for(int i = 0; i < n; i++){
            maxProfit = Math.max(maxProfit, dpMax[i] - dpMin[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] test = {3000, 3000, 5000, 8000, 2000, 200};
        System.out.println(maxProfit(test));

    }
}

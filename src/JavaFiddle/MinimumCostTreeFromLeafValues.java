package JavaFiddle;

import java.util.ArrayDeque;
import java.util.Deque;

class MyPair<T1, T2>{
    T1 key;
    T2 value;

    public MyPair(T1 key, T2 value) {
        this.key = key;
        this.value = value;
    }
}

public class MinimumCostTreeFromLeafValues {

    public static MyPair<Integer, Integer> computeCost(int start, int end, int[] arr){
        int length = end - start  + 1;
        MyPair<Integer, Integer> minPair = new MyPair<>(Integer.MAX_VALUE, Integer.MAX_VALUE);
        if(length == 1)
            return new MyPair<>(0 , arr[start]);

        if(length == 2)
            return new MyPair<>(arr[start]*arr[end] , Math.max(arr[start], arr[end]));

        for(int i = start; i < end; i++){
            MyPair<Integer, Integer>
                    left = computeCost(start, i, arr),
                    right = computeCost(i+1, end, arr);

            int
                    nodeValue = left.value*right.value,
                    prevNode = left.key + right.key;
            if(minPair.key > prevNode + nodeValue){
                minPair = new MyPair<>(prevNode + nodeValue, Math.max(left.value, right.value));
            }
        }
        return minPair;
    }

    //Solution #2
    public int mctFromLeafValues(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i <= arr.length; i++) {
            int num = i == arr.length ? Integer.MAX_VALUE : arr[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                int x = stack.pop();
                ans += stack.isEmpty() ? (num == Integer.MAX_VALUE ? 0 : num * x) : x * Math.min(stack.peek(), num);
            }
            stack.push(num);
        }
        return ans;
    }

    private static int mctFromLeafValues2Helper(int start, int end, int arr[], int dp[][]){
        int length = end - start + 1, minValue = Integer.MAX_VALUE;
        if(length == 1) return Integer.MAX_VALUE;
        if(length == 2) return arr[start]*arr[end];

        for(int i = start; i < end; i++){
            int currentValue = Math.min(mctFromLeafValues2Helper(start, i, arr, dp), mctFromLeafValues2Helper(i+1, end, arr, dp))
                    + dp[start][i]*dp[i+1][end];
            minValue = Math.min(minValue, currentValue);
        }
        return minValue;
    }

    public static int mctFromLeafValues2(int[] arr){
        int[][] dp = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length; i++){
            dp[i][i] = arr[i];
            for(int j = i+1; j < arr.length; j++){
                dp[i][j] = Math.max(arr[j], dp[i][j-1]);
            }
        }
//        for(int i = 0; i < arr.length; i++){
//            for(int j = i; j < arr.length; j++){
//                System.out.print(" " + dp[i][j]);
//            }
//            System.out.println("");
//        }
        int res = mctFromLeafValues2Helper(0, arr.length -1, arr, dp);

        return res;
    }

    public static void main(String[] args) {
        int[] testArr = {6,2,4};
        System.out.println(computeCost(0, testArr.length-1, testArr).key);
    }
}

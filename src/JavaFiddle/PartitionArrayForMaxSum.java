package JavaFiddle;

import java.util.HashMap;

public class PartitionArrayForMaxSum {
    private static HashMap<String, Integer> map = new HashMap<>();

    public static int maxSumAfterPartition(int i, int j, int k, int[] arr){
        int len = j - i + 1, max = Integer.MIN_VALUE;

        if(map.get(i+"_"+j) != null) return map.get(i+"_"+j);
        if(len <= k){
            max = getMax(arr, i, j)*len;
            map.put(i+"_"+j, max);
            return max;
        }
        for(int ptr = i; ptr < j; ptr++){
            int
                    leftVal = maxSumAfterPartition(i, ptr, k, arr),
                    rightVal = maxSumAfterPartition(ptr+1, j, k, arr);


            max = Math.max(max, leftVal + rightVal);
        }
        map.put(i+"_"+j, max);
        return max;
    }

    private static int getMax(int[] arr, int i, int j){
        int max = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++){
            max = Math.max(max, arr[k]);
        }
        return max;
    }

    public static void main(String[] args) {
        int testArr[] = {1,15,7,9,2,5,10}, testK = 3;
        System.out.println(maxSumAfterPartition(0, testArr.length -1, testK, testArr));
    }
}

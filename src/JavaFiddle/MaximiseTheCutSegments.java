package JavaFiddle;

import java.util.HashMap;

public class MaximiseTheCutSegments {
    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static int getSegmentCount(int n, int ...segments){
        if(map.get(n) != null) return map.get(n);
        int max = 0;
        if(n < 0) return Integer.MIN_VALUE;
        if(n == 0) return 0;
        for(int i = 0; i < segments.length; i++){
            int pieces = getSegmentCount(n- segments[i], segments);
            max = Math.max(max, pieces+1);
        }
        map.put(n, max);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getSegmentCount(7, 2,2,3));
        map = new HashMap<>();
    }
}

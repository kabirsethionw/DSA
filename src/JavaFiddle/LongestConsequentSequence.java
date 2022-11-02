package JavaFiddle;

import java.util.HashMap;

public class LongestConsequentSequence {
    public static int getCount(int[] arr){
        int max = 0;
        HashMap<Integer, Boolean> isVisited = new HashMap<>();
        for(int elem: arr){
            if(isVisited.get(elem) == null){
                isVisited.put(elem, false);
            }
        }
        for(int elem: arr){
            if(!isVisited.get(elem)){
                int left = 0, lptr = elem - 1, right = 0, rptr = elem + 1, val = 0;
                while(isVisited.get(lptr) != null) {
                    left += 1;
                    isVisited.put(lptr, true);
                    lptr--;
                }
                while(isVisited.get(rptr) != null) {
                    right += 1;
                    isVisited.put(rptr, true);
                    rptr++;
                }
                val = 1 + left + right;
                max = Math.max(max, val);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] testArr = {100, 100, 5, 101, 6, 7, 8};
        System.out.println(getCount(testArr));
    }
}

package JavaFiddle;

import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static int solution(int[] arr){
        int counter =0, maxCount = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int elem: arr){
            map.put(elem, true);
        }
        for(int i = 0; i < arr.length; i++){
            if(map.get(arr[i]-1) == null){
                int elem = arr[i]; counter = 1;
                while(map.get(++elem ) != null) counter++;
                maxCount = Math.max(maxCount, counter);
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int testArr[] = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(solution(testArr));
    }
}

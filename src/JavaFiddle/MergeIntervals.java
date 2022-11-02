package JavaFiddle;

import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> sortedIntervals = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        int index = 0;
        for(int[] range: intervals){
            if(map.get(range[0]) == null || map.get(range[0]) < range[1]) {
                map.put(range[0], index++);
                sortedIntervals.add(range[0]);
            }
        }
        Collections.sort(sortedIntervals);
//        sortedIntervals.forEach((elem)->{
//            int[] range = intervals[map.get(elem)];
//            System.out.println(range[0]+" "+range[1]);
//        }
        //);

        int[] prev = intervals[map.get(sortedIntervals.get(0))];
        stack.push(prev);
        //System.out.println(prev[0]+" "+prev[1]);
        for(int i = 1; i < sortedIntervals.size(); i++){
            int[] curr = intervals[map.get(sortedIntervals.get(i))];
            //System.out.println(curr[0]+" "+curr[1]);
            if(curr[0] <= prev[1]){
                stack.pop();
                int elem0 = Math.min(prev[0], curr[0]), elem1 = Math.max(prev[1], curr[1]), arr[] = {elem0, elem1};
                //System.out.println("Adding "+arr[0]+" "+arr[1]);
                stack.push(arr);
                prev = arr;
            }else{
                stack.push(curr);
            }
        }
        int size = stack.size();
        //System.out.println(size);
        for(int i = 0; i < size; i++){
            int[] elem = stack.pop();
            System.out.println(elem[0]+", "+elem[1]);
        }

        return null;
    }

    public static void main(String[] args) {
        int[][] testMat= {{1,3},{8,10},{15,18},{2,6}};
        merge(testMat);

    }
}

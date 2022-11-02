package JavaFiddle;

import java.util.ArrayList;
import java.util.Comparator;

public class NumberOfSwapsToSortAnArray {
    public static int getSwapCounts(int[] arr){
        ArrayList<MyPair<Integer, Integer>> rec = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];
        int swaps = 0;
        for(int i = 0; i < arr.length; i++){
             rec.add(new MyPair<>(arr[i], i));
        }
        sortPairs(rec);
        for(int i = 0; i < arr.length; i++){
            if(visited[i] || rec.get(i).value == i) continue;
            int ptr = i, hops = 0;
            while(!visited[ptr]){
                visited[ptr] = true;
                ptr = rec.get(ptr).value;
                hops++;
            }
            if(hops > 0) swaps += (hops-1);
        }
        return swaps;
    }

    private static void sortPairs(ArrayList<MyPair<Integer, Integer>> rec){
        rec.sort((o1, o2) -> {
            if(o1.key > o2.key) return 1;
            return o1.key == o2.key ? 0 : -1;
        });
    }

    public static void main(String[] args) {
        int test[] = {1, 5, 4, 3, 2};
        System.out.println(getSwapCounts(test));
    }
}

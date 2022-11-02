package JavaFiddle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxNoOfEventsThatCanBeAttended {
    public static int computeMaxEventsAttended(int events[][]){
        Arrays.sort(events, (a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < events.length; i++){
            for(int j = events[i][0]; j <= events[i][1]; j++){
                if(set.add(j))
                    break;
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        int testMat[][] = {{1,1}, {2,2}, {1,2}};
        System.out.println(computeMaxEventsAttended(testMat));
    }
}

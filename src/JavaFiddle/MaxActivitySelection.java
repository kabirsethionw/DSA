package JavaFiddle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MaxActivitySelection {
    public static int maxActivity(int start[], int end[], int n){
        int
                count = 0,
                finalDay = 0;
        for(int i = 0; i < n; i++){
            finalDay = Math.max(finalDay, end[i]);
        }
        ArrayList<MyPair<Integer, Integer>> activities = new ArrayList();
        for(int i = 0; i < n; i++){
            activities.add(new MyPair(start[i], end[i]));
        }
        Collections.sort(activities, (t1, t2) ->
                t1.key == t2.key ? (t1.value - t2.value) : (t1.key - t2.key)
        );
        boolean booked[] = new boolean[finalDay];
        for(int i = 0; i < n; i++){
            MyPair<Integer, Integer> activity = activities.get(i);
            for(int j = activity.key-1; j < activity.value; j++){
                if(booked[j] == false){
                    booked[j] = true;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int start[] = {1, 3, 2, 5}, end[] = {2, 4, 3, 6}, n = start.length;

        System.out.println(maxActivity(start, end, n));
    }
}

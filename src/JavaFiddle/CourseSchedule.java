package JavaFiddle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class CourseSchedule {
    public static boolean canFinish(int n, int[][] pre) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[n+1];
        if(pre.length == 1 || pre.length == 0) return true;
        for(int i = 0; i < pre.length; i++){
            if(map.get(pre[i][0]) == null){
                List<Integer> newList = new ArrayList<>();
                newList.add(pre[i][1]);
                map.put(pre[i][0], newList);
            }
            else{
                map.get(pre[i][0]).add(pre[i][1]);
            }
        }

        for(int i = 0; i < n; i++){
            if(map.get(i) == null) continue;
            boolean con = true;
            int ptr = i;

            while(con){
                List adjList = map.get(ptr);
                if(visited[ptr]) return false;
                if(adjList == null || adjList.isEmpty()){
                    con = !(stack.isEmpty() && map.get(ptr).isEmpty());
                    if(!stack.isEmpty()){
                        ptr = (Integer)stack.pop();
                        map.get(ptr).remove(0);
                        visited[ptr] = false;
                    }

                }
                else{
                    stack.push(ptr);
                    visited[ptr] = true;
                    ptr = (int)adjList.get(0);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int testArray[][] = {{1,4},{2,4},{3,1},{3,2}}, test = 5;
        System.out.println(canFinish(test, testArray));
    }
}
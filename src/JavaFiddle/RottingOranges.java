package JavaFiddle;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Point{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class RottingOranges {
//    private static void rot(int[][] grid, int i, int j, Queue<Point> q){
//        if()
//    }

    public static int getTimeToRot(int[][] grid) {
        // add your logic here
        int
                n = grid.length,
                m = grid[0].length,
                freshOranges = 0,
                curr = 0, next = 0, time = 0;

        Queue<Point> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) freshOranges++;
                if(grid[i][j] == 2){
                    q.add(new Point(j-1, i));
                    q.add(new Point(j+1, i));
                    q.add(new Point(j, i-1));
                    q.add(new Point(j, i+1));
                };
            }
        }

        curr = q.size();
        while(!q.isEmpty()){
            if(curr == 0){
                time++;
                curr = next;
                next = 0;
            }
            curr--;
            Point point = q.poll();
            int x = point.x, y = point.y;
            if(x < 0 || x >= m) continue;
            if(y < 0 || y >= n) continue;
            if(grid[y][x] == 2 || grid[y][x] == 0) continue;
            grid[y][x] = 2;
            freshOranges--;
            q.add(new Point(x-1, y));
            q.add(new Point(x+1, y));
            q.add(new Point(x, y-1));
            q.add(new Point(x, y+1));
            next += 4;
        }

        return freshOranges != 0 ? -1 : time;
    }

    public static void main(String[] args) {
        int grid[][] = {
                {2, 1, 0},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(getTimeToRot(grid));
    }
}

package JavaFiddle;

import java.util.Stack;

public class MaxRectangleAreaInHistogram {
    class Entry{
        private int index;
        private int height;

        public Entry(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Entry> stack = new Stack<>();
        int maxArea = 0, i;
        for(i = 0; i < heights.length; i++){
            if(stack.isEmpty() || ((Entry)stack.peek()).height <= heights[i])
                stack.push(new Entry(i, heights[i]));
            else {
                Entry entry = null;
                while(!stack.isEmpty() && ((Entry)stack.peek()).height > heights[i]){
                    entry = (Entry)stack.pop();
                    maxArea = Math.max((i-entry.index)*entry.height, maxArea);
                }
                stack.push(new Entry(entry.index, heights[i]));
            }
        }

        while(!stack.isEmpty()) {
            Entry entry = (Entry) stack.pop();
            maxArea = Math.max((i - entry.index) * entry.height, maxArea);
        }

        return maxArea;
    }

    public int[] customLargestRectangleArea(int[] heights) {
        Stack<Entry> stack = new Stack<>();
        int maxArea = 0, i , dim[] = new int[2];
        for(i = 0; i < heights.length; i++){
            if(stack.isEmpty() || ((Entry)stack.peek()).height <= heights[i])
                stack.push(new Entry(i, heights[i]));
            else {
                Entry entry = null;
                while(!stack.isEmpty() && ((Entry)stack.peek()).height > heights[i]){
                    entry = (Entry)stack.pop();
                    if((i-entry.index)*entry.height > maxArea){
                        dim[0] = entry.height;
                        dim[1] = (i-entry.index);
                        maxArea = (i-entry.index)*entry.height;
                    }
                }
                stack.push(new Entry(entry.index, heights[i]));
            }
        }

        while(!stack.isEmpty()) {
            Entry entry = (Entry) stack.pop();
            if((i-entry.index)*entry.height > maxArea){
                dim[0] = entry.height;
                dim[1] = (i-entry.index);
                maxArea = (i-entry.index)*entry.height;
            }
        }

        return dim;
    }

    public static void main(String[] args) {
        int testArr[] = {3,1,3,2,2};
        System.out.println(new MaxRectangleAreaInHistogram().largestRectangleArea(testArr));
    }
}

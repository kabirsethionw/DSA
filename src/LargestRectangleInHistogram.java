import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        ArrayList<ArrayList<Integer>> stack = new ArrayList<>();

        for(int i = 0; i < heights.length; i++){
            boolean sameHeightEntryExistsInStack = false;
            ArrayList<Integer> entry = new ArrayList<>();
            entry.add(i);
            entry.add(heights[i]);

            if(stack.isEmpty()){
                stack.add(entry);
            }
            else{
                for(int j = stack.size() - 1; j > -1 ; j--){
                    ArrayList<Integer> prevEntry = stack.get(j);

                    if(prevEntry.get(1) > entry.get(1)){
                        int area = prevEntry.get(1).intValue()*(j - prevEntry.get(0).intValue());
                        maxArea = Math.max(maxArea, area);
                        entry.set(0, prevEntry.get(0));
                        stack.remove(j);
                    }
                    else if(prevEntry.get(1) == entry.get(1)){
                        sameHeightEntryExistsInStack = true;
                    }
                    else{// prevEntry.get(1) < entry.get(1)
                    }
                }

                if(!sameHeightEntryExistsInStack){
                    stack.add(entry);
                }
            }

            if(i == heights.length - 1){
                for(int j = stack.size() - 1; j > -1 ; j--){
                    ArrayList<Integer> elem = stack.get(j);
                    int area = elem.get(1).intValue()*(j - elem.get(0).intValue() + 1);
                    maxArea = Math.max(maxArea, area);
                }
                stack = new ArrayList<>();
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int test[] = {1,2,4,2,1};
        System.out.println(largestRectangleArea(test));
    }
}

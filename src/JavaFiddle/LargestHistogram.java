package JavaFiddle;

import java.util.LinkedList;
import java.util.Queue;

class InfoObject{
    private int ptr;
    private int length;
    private int minLen;

    public int getPtr() {
        return ptr;
    }

    public int getLength() {
        return length;
    }

    public int getMinLen() {
        return minLen;
    }

    public void setPtr(int ptr) {
        this.ptr = ptr;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setMinLen(int minLen) {
        this.minLen = minLen;
    }

    public InfoObject(int ptr, int length, int minLen) {
        this.ptr = ptr;
        this.length = length;
        this.minLen = minLen;
    }
}

public class LargestHistogram {
    public static int maxArea = 0;

    public static int findMaxArea(int[] arr){
        int ptr = 0;
        Queue<InfoObject> queue = new LinkedList<>();
        queue.add(new InfoObject(ptr, 0, Integer.MAX_VALUE));

        while(ptr < arr.length){
            int snapShot = queue.size(), longestLen = 0;
            boolean sameOrMoreHeight = false;
            for(int i = 0; i < snapShot; i++){
                InfoObject info = queue.peek();
                if(arr[ptr] <= info.getMinLen()){
                    if(arr[ptr] == info.getMinLen())
                        sameOrMoreHeight = true;
                        longestLen = info.getLength();

                }
                else{
                    maxArea = maxArea > (info.getLength() + 1)*info.getMinLen() ? maxArea : (info.getLength() + 1)*info.getMinLen();
                    InfoObject newInfo = new InfoObject(ptr + 1, info.getLength() + 1, info.getMinLen());
                    queue.add(newInfo);
                    maxArea = maxArea > 1*arr[ptr] ? maxArea : 1*arr[ptr];
                    newInfo = new InfoObject(ptr + 1, 1, arr[ptr]);
                    queue.add(newInfo);
                }
            }
            maxArea = maxArea > (longestLen + 1)*arr[ptr] ? maxArea : (longestLen + 1)*arr[ptr];
            InfoObject newInfo = new InfoObject(ptr + 1, longestLen + 1, arr[ptr]);
            queue.add(newInfo);
//            sameOrMoreHeight = false;

        }
        return maxArea;
    }

}

package JavaFiddle;

public class ShortestUnsortedSubArray {
    public static boolean isPlacedWell(int ptr, int[] arr){
        int left = 0, right = arr.length - 1;
        boolean lDone = false, rDone = false;
        while(!lDone || !rDone){
            if(left < ptr && arr[left] <= arr[ptr]) left++;
            else lDone = true;

            if(right > ptr && arr[right] >= arr[ptr]) right--;
            else rDone = true;
        }
        if(left != ptr || right != ptr) return true;
        else return false;
    }

    public static int findUnsortedSubarray(int[] nums) {
        int ptr1 = -1, ptr2 = nums.length;
        boolean leftCon = false, rightCon = false;
        while(!leftCon || !rightCon){
            if(!leftCon)
                leftCon = isPlacedWell(++ptr1, nums);
            if(!leftCon)
                rightCon = isPlacedWell(--ptr2, nums);
        }
        return ptr2 - ptr1 + 1;
    }

    public static void main(String[] args) {
        int test[] = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(test));
    }
}

package JavaFiddle;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int
                n = nums.length,
                ptr = n-2;
        while(ptr > -1 && nums[ptr] >= nums[ptr +1]) ptr--;

        if(ptr == -1) reverseSubArray(nums, 0, n - 1);
        else{
            int temp = nums[ptr];
            nums[ptr] = nums[ptr+1];
            nums[ptr+1] = temp;
            placeElement(nums, ptr+1);
            reverseSubArray(nums, ptr + 1, n - 1);
        }
        //return nums;
    }

    private static void placeElement(int[] nums, int ptr){
        if(ptr == nums.length-1) return;
        int n = nums.length, loc = ptr + 1, temp = nums[ptr];
        while(loc < n && temp < nums[loc]){
            nums[loc - 1] = nums[loc++];
        }
        loc = loc == n ? n-1 : loc;
        nums[loc] = temp;
    }

    private static void reverseSubArray(int[] nums, int start, int end){
        int left = start, right =end;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp; left++; right--;
        }
    }

    public static void main(String[] args) {
        int testArr[] = {1,2,3,1,7,6,5,4};
        nextPermutation(testArr);
        for(int elem: testArr) System.out.print(" " + elem);
    }
}
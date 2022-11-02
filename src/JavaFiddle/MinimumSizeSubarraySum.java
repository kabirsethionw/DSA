package JavaFiddle;

import java.util.Arrays;

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = nums.length, mid, minLength = nums.length;
        while(start <= end){
            mid = (start+end)/2;
            if(checkArr(nums, mid, target)){
                minLength = Math.min(minLength, mid);
                end = mid - 1;
            }
            else start = mid + 1;
        }
        return minLength == nums.length ? 0 : minLength;
    }

    private static boolean checkArr(int[] arr, int size, int target){
        int sum = 0, first = 0, limit = size - 1, last = 0;
        while(last < arr.length + 1){
            last = first + limit + 1;
            sum = Arrays.stream(Arrays.copyOfRange(arr, first, last)).sum();
            if(sum >= target) return true;
            first++;
        }
        return false;
    }

    public static void main(String[] args) {
        int testArr[] = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, testArr));
    }
}

package JavaFiddle;

import java.util.Arrays;

public class RemoveDuplicateInSortedArray {
    public static int removeDuplicates(int[] nums) {
        int ptr = 1, dup = 0, len = nums.length;
        while(ptr < len && nums[ptr-1] <= nums[ptr]){
            if(nums[ptr] == nums[ptr-1]) {
                int count = 2, ptr2 = ptr+1, ptr3 = ptr+1;
                while(ptr2 < len && nums[ptr2] == nums[ptr2 - 1]){ count++; ptr2++; };
                if(count > 2) {
                    while(ptr2 < len) nums[ptr3++] = nums[ptr2++];
                }
                len -= (count - 2);
            }
            ptr++;
        }
        return len;
    }

    public static void main(String[] args) {
        int arr[] = {0,0,1,1,1,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(arr));
    }
}

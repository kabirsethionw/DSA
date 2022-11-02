package JavaFiddle;

public class MedianOf2SortedArraysV1 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //intitial partition
        int total = nums1.length + nums2.length, ptr1, ptr2, start1, end1, start2, end2;
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        ptr1 = (int)((0 + nums1.length -1)/2 );
        ptr2 = (int)(total+1)/2 - (ptr1 + 1) -1;
        start1 = 0; start2 = 0;
        end1 = nums1.length - 1; end2 = nums2.length -1;
        try {
            while (true) {
                if (nums1[ptr1] <= nums2[ptr2 + 1] && nums2[ptr2] <= nums1[ptr1 + 1]) {
                    if (total % 2 == 0) {
                        return (Math.min(nums1[ptr1], nums2[ptr2]) + Math.max(nums1[ptr1 + 1], nums2[ptr2 + 1])) / 2;
                    } else {
                        return Math.max(nums1[ptr1], nums2[ptr2]);
                    }
                } else {
                    if (nums1[ptr1] > nums2[ptr2 + 1]) { // move ptr1 to left and ptr2 to right
                        end1 = ptr1;
                        ptr1 = (start1 + end1) / 2;
                        start2 = ptr2;
                        ptr2 = (start2 + end2) / 2;
                    } else if (nums2[ptr2] > nums1[ptr1 + 1]) {// move ptr2 to left and ptr1 to right
                        end2 = ptr2;
                        ptr2 = (start2 + end2) / 2;
                        start1 = ptr1;
                        ptr1 = (start1 + end1) / 2;
                    }
                    else if(ptr1 == 0 || ptr1 == nums1.length -1 || ptr2 == 0 || ptr2 == nums2.length -1 ){
                        //logic to return median in non overlapping arrays
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return -1d;
        }
    }

    public static void main(String[] args) {

        int test1[] = {1,2,3,4,5,6}, test2[] = {7,8,9,10};
        System.out.println(MedianOf2SortedArraysV1.findMedianSortedArrays(test1, test2));

    }
}

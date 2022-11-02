package JavaFiddle;

public class MinimumSwapsToMakeSequencesIncreasing {
    public static int getMinSwaps(int[] nums1, int[] nums2){
        int
                n = nums1.length,
                swap[] = new int[n],
                notSwap[] = new int[n];

        swap[0] = 1;

        for(int i = 1; i < n; i++){
            swap[i] = Integer.MAX_VALUE;
            notSwap[i] = Integer.MAX_VALUE;

            if(nums1[i] > nums1[i-1] && nums2[i] > nums2[i-1]){
                swap[i] = swap[i-1] + 1; //if we started swapping from 1st elem then we have to swap next elem as the initial sequence was in increasing order.
                notSwap[i] = notSwap[i-1]; // we did not swap so same as i-1
            }
            if(nums1[i] > nums2[i-1] && nums2[i] > nums1[i-1]){
                swap[i] = Math.min(swap[i], notSwap[i-1] + 1);// we did swap for notSwap[i-1] path, this time if is false and add to swap[i] because we did swap this time coming from notSwap[i-1] path.
                notSwap[i] = Math.min(notSwap[i], swap[i-1]);//when above if is not true but this if is true then we simply replace notSwap[i] with swap[i-1] as we didn't need to swap for the previous notSwap[i-1] path
            }
        }

        return Math.min(swap[n-1], notSwap[n-1]);
    }

    public static void main(String[] args) {
        int[] nums1 = {0,3,5,8,9}, nums2 = {2,1,4,6,9};
        System.out.println(getMinSwaps(nums1, nums2));
    }
}

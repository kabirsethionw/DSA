class TwoSum {

    public static int binarySearchForSumMatch(int[] nums, int target, int index){
        int start = 0, end = nums.length -1, mid;
        while(start <= end){// mid should be != index
            mid = (start + end)/2;
            if(mid == index){
                if(mid < 0){
                    mid = mid -1;
                }
                else{
                    mid = mid +1;
                }
            }
            else{
                System.out.println(mid);
                if(nums[mid] + nums[index] == target){
                    return mid;
                }
                else if(nums[mid] + nums[index] > target){
                    end = mid -1;
                }
                else{
                    start = mid +1;
                }
            }
        }
        return -1;
    }

    public static int[] twoSum(int[] numbers, int target) {
        int loc1 = 0, loc2 = 0;
        for(int i = 0; i < numbers.length; i++){
            loc1 = i;
            loc2 = TwoSum.binarySearchForSumMatch(numbers, target, i);
            if(loc2 != -1)
                break;
        }
        int res[] = {loc1+1, loc2+1};
        return res;
    }

    public static void main(String[] args) {
        int testArr[] = {-1, 0};
        TwoSum.twoSum(testArr, -1);
    }
}
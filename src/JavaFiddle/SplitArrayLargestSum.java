package JavaFiddle;

public class SplitArrayLargestSum {
    public static int splitArray(int[] nums, int m) {
        int sum = 0;
        for(int elem: nums){
            sum += elem;
        }
        int start = 0, end = sum, mid, min = Integer.MAX_VALUE;
        while(start <= end){
            mid = (start+end)/2;
            if(check(nums, mid, m)){
                end = mid - 1;
                min = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return min;
    }

    public static boolean check(int[] nums, int sum, int m){
        int n = 1, prevSum = 0;
        for(int elem: nums){
            if(prevSum > sum){
                return false;
            }
            if(elem + prevSum <= sum){
                prevSum += elem;
            }
            else{
                prevSum = elem;
                n++;
            }
        }

        if(n <= m)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int nums[] = {2,3,1,2,4,3}, m = 5;
        System.out.println(SplitArrayLargestSum.splitArray(nums, m));
    }
}

package JavaFiddle;




public class SumOf2MiddleElementOf2SortedArrays {

    public static void main(String[] args) throws Exception {
        int[]
                ar1 = {5, 10, 12, 16, 17, 18, 22, 24, 27, 29, 29, 29},
                ar2 = {5, 7, 9, 10, 10, 13, 16, 18, 20, 22, 26, 29};
            System.out.println(new Test().findMidSum(ar1, ar2, 12));
        }
    }

class Test {
    int findMidSum(int[] ar1, int[] ar2, int n) {
        // code here
        int mid = 0, left1 = 0, left2 = 0, right1 = 0, right2 = 0, start = 0, end = 0;
        start = 0;
        end = n-1;
        while(true){
            mid = (start + end)/2;
            left1 = mid < 0 ? -Integer.MAX_VALUE : ar1[mid];
            right1 = mid + 1 > n-1 ? Integer.MAX_VALUE : ar1[mid + 1];
            left2 = n - mid - 2 < 0 ? -Integer.MAX_VALUE : ar2[n - mid - 2];
            right2 = n - mid - 1 > n-1 ? Integer.MAX_VALUE : ar2[n - mid - 1];
            if(left1 <= right2 && left2 <= right1){
                break;
            }
            else if(left1 > right2) end = mid -1;
            else if(left2 > right1) start = mid + 1;
        }

        return Math.max(left1, left2) + Math.min(right1, right2);
    }
}

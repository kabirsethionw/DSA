package JavaFiddle;

import java.util.Arrays;

class ThreeSumClosest {

    public static int sum3Closest(int[] arr,int elem){
        int[] win = new int[3], arr1, arr2, arr3;
        int ptr = 0, sum = 0;
        if(arr.length > 2){
            System.arraycopy(arr, 0, win, 0, 3);
            sum = ThreeSumClosest.sum(win);
            ptr++;
            while(ptr < arr.length - 3){
                arr1 = win.clone();
                arr1[0] = arr[ptr + 3];
                arr2 = win.clone();
                arr2[1] = arr[ptr + 3];
                arr3 = win.clone();
                arr3[0] = arr[ptr + 3];

                win = ThreeSumClosest.minArr(arr1, arr2, arr3, win, elem);
                ptr++;

            }
            return ThreeSumClosest.sum(win);
        }
        return 0;
    }

    public static int sum(int[] arr){
        return Arrays.stream(arr).reduce((i1, i2) -> i1 + i2).getAsInt();
    }

    public static int[] minArr(int[] arr1, int[] arr2, int[] arr3, int[] arr, int elem){
        int val1, val2, val3, val, minVal;
        int[] min;
        val1 = Math.abs(elem - ThreeSumClosest.sum(arr1));
        val2 = Math.abs(elem - ThreeSumClosest.sum(arr2));
        val3 = Math.abs(elem - ThreeSumClosest.sum(arr3));
        val = Math.abs(elem - ThreeSumClosest.sum(arr));
        if(val1 < val2){
            if(val1 < val3){
                min = arr1; minVal = val1;
            }
            else{
                min = arr3; minVal = val3;
            }
        }
        else{
            if(val2 < val3){
                min = arr2; minVal = val2;
            }
            else{
                min = arr3; minVal = val3;
            }
        }

        if(minVal < val)
            return min;
        else
            return arr;

    }

    public int threeSumClosest(int[] nums, int target) {
        return ThreeSumClosest.sum3Closest(nums, target);
    }

    public static void main(String[] args) {
        int[] test = {-1,2,1,-4, 1};
        System.out.println(ThreeSumClosest.sum3Closest(test, 1));
    }
}

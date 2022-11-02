package JavaFiddle;

import java.util.Arrays;

public class SwappingPairsMakeSumEqual {
    private static long sum(long arr[]){
        long sum = 0;
        for(long elem: arr) sum += elem;
        return sum;
    }

    //Alternative is to use hash on array1(with smaller size) and check if "need + array2[i])" is present in hash.
    static long findSwapValues(long A[], int n, long  B[], int m)
    {
        // Your code goes here
        int ptrA = 0, ptrB = 0;
        Arrays.sort(A); Arrays.sort(B);
        long sumA = sum(A), sumB = sum(B), need = (sumA + sumB)/2 - sumA, differ = Math.abs(sumA-sumB);
        //System.out.println("sumA "+sumA+", sumB "+sumB+", need "+need);
        if(differ == 1 || differ == 0) return -1;
        while(ptrA < n && ptrB < m){
            long diff = B[ptrB] - A[ptrA];
            if(diff == need){
                //System.out.println(B[ptrB] + " - "+ A[ptrA]+", diff "+diff);
                return 1;
            }
            else if(diff > need) ptrA++;
            else ptrB++;
        }
        return -1;
    }

    public static void main(String[] args) {
        long
                a[] = {61, 89, 61, 72, 69, 4, 45, 40, 77, 95, 39, 20, 23, 24, 49, 40, 27, 6, 66, 84, 29, 78, 15, 83, 26, 21, 42, 98, 3, 85, 27, 30, 61, 29, 39, 3, 88, 30, 67, 5, 42, 3, 14, 28, 3, 9, 45, 38, 27, 80, 10, 51, 79, 96, 67, 66, 60, 55, 5, 99, 4, 43, 68, 20, 86, 23, 68, 31, 80, 42, 52, 52, 23, 91, 63, 7, 86, 18, 32, 89, 59, 47, 98, 96, 7, 13, 24, 44, 53, 2, 57, 51, 48, 69, 7, 31, 88, 46, 41, 30, 18, 41, 51, 66, 34, 78, 48, 91, 42, 8, 90, 46, 60, 28, 21, 31, 65, 100, 21, 33, 52, 43, 78, 44, 97, 8, 33, 31, 50, 31, 81, 19, 97, 74, 53, 28, 88, 76, 67, 23, 53, 14, 9, 91, 34, 35, 36, 20, 88, 42, 7, 13, 10, 85, 9, 17, 93, 84, 41, 20, 98, 6, 8, 38, 31, 90, 63, 49, 41, 86, 4, 66, 29, 9, 27, 10, 21, 39, 22, 75, 2},
                b[] = {58, 8, 96, 48, 22, 17, 85, 5, 88, 7, 66, 86, 82, 66, 71, 86, 49, 98, 40, 12, 100, 41, 98, 92, 8, 24, 18, 65, 33, 91, 88, 13, 45, 95, 94, 88, 10, 98, 22, 49, 56, 83, 33, 47, 99, 32, 54, 47, 82, 18, 15, 63, 1, 92, 46, 23, 100, 90, 30, 77, 68, 47, 39, 54, 38, 17, 51, 91, 94, 12, 43, 1, 66, 2, 22, 45, 22, 73, 72, 22, 66, 93, 17, 52, 62, 92, 18, 85, 49, 99, 28, 10, 53, 91, 16, 5, 82, 68, 76, 52, 42, 44, 16, 48, 31, 39, 59, 79, 71, 54, 55, 3, 44, 41, 53, 80, 46, 78, 38, 32, 90, 30, 23, 84, 20, 18, 96, 70, 60, 87, 11, 73, 45, 41, 21, 72, 10, 82, 41, 91, 89, 1, 88, 2, 41, 21, 33, 79, 42, 8, 46, 34, 100, 44, 27, 87, 24};
        System.out.println(findSwapValues(a, a.length, b, b.length));
    }
}

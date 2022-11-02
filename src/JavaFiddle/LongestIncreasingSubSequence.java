package JavaFiddle;

public class LongestIncreasingSubSequence {
    private static int maxLen =0;

    private static void longestIncreasingSubSeqRec(int arr[], int len, int last, int ptr){
        if(ptr == arr.length) maxLen = Math.max(maxLen, len);
        else{
            if(arr[ptr] > last) longestIncreasingSubSeqRec(arr, len+1, arr[ptr], ptr + 1);;
            longestIncreasingSubSeqRec(arr, len, last, ptr +1);
        }
    }

    public static int solution(int arr[]){
        longestIncreasingSubSeqRec(arr, 0, -1, 0);
        return maxLen;
    }

    public static void main(String[] args) {
        int testArr[] = {3,1,2,4,7,9,6,7, 10};
        System.out.println(solution(testArr));
    }
}

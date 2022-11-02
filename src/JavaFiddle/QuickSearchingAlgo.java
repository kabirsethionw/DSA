package JavaFiddle;

public class QuickSearchingAlgo {
    public static int binarySearch(int[] arr, int elem){
        int start = 0, end = arr.length-1, mid;
        while(start <= end){
            mid = (start + end)/2;
            if(arr[mid] == elem){
                return mid;
            }
            else if(arr[mid] > elem){
                end = mid -1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = {1,4,6,8,9,11,14,17,30};//{1,1,1,3,3,3,3,3,4,4,4,4,4,4,4,4,5,5,5,5,5,5,6,6,6,6,6,7,7,7,7,8,8,9,9,9,9,9};
        System.out.println(QuickSearchingAlgo.binarySearch(test, 4));
    }
}

package JavaFiddle;

public class FindElementAndRepetition {

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

    public static int findRight(int[] arr, int loc, int end,int elem){
        int mid = -1;
        while(loc <= end){
            mid = (loc + end)/2;
            if(arr[mid] == elem){
                loc = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return end;
    }

    public static int findLeft(int[] arr, int loc, int start,int elem){
        int mid = -1;
        while(loc >= start){
            mid = (loc + start)/2;
            if(arr[mid] == elem){
                loc = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return start;
    }

    public static int ganduFunction(int[] arr, int elem){
        int loc = FindElementAndRepetition.binarySearch(arr, elem);
        int left, right;
        left = FindElementAndRepetition.findLeft(arr, loc, 0, elem);
        right = FindElementAndRepetition.findRight(arr, loc, arr.length -1, elem);
        System.out.println(right-left+1);
        return right-left+1;
    }

    public static void main(String[] args) {
        int[] test = {0,1,1,1,3,3,3,3,3,4,4,4,4,4,4,4,4,5,5,5,5,5,5,6,6,6,6,6,7,7,7,7,8,8,9,9,9,9,9};
        FindElementAndRepetition.ganduFunction(test, 1);
    }
}

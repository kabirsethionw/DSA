package JavaFiddle;

public class SearchInPyramid {

    public static int findTop(int[] arr){
        int start = 0, end = arr.length-1, mid;
        while(start + 1 < end ){
            mid = (start + end)/2;
            System.out.println("mid: " + mid);
            if(arr[mid -1] < arr[mid] && arr[mid] > arr[mid+1]){
                return mid;
            }
            else if(arr[mid -1] < arr[mid] && arr[mid] < arr[mid+1]){ // focus on right|
                start = mid;
            }
            else if(arr[mid -1] > arr[mid] && arr[mid] > arr[mid+1]){ // focus on right|
                end = mid;
            }
            else{
                return -1; 
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int elem, int start, int end){
        int mid;
        while(start < end){
            mid = (start + end)/2;
            if(arr[mid] == elem){
                return mid;
            }
            else if(arr[mid] < elem){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int descBinarySearch(int[] arr, int elem, int start, int end){
        int mid;
        while(start < end){
            mid = (start + end)/2;
            if(arr[mid] == elem){
                return mid;
            }
            else if(arr[mid] < elem){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,8,14,11,9,4,2};
        int elem = 22;
        int mid = SearchInPyramid.findTop(arr);
        if(mid != -1 && arr[mid] == elem){
            System.out.println("true");
        }
        else if (mid != -1){
            int mid1 = SearchInPyramid.binarySearch(arr, elem, 0, mid -1);
            int mid2 = SearchInPyramid.descBinarySearch(arr, elem, mid + 1, arr.length-1);
            if(mid1 != -1 || mid2 != -1){
                System.out.println("true");
            }
            else{
                System.out.println("false");
            }
        }
        else if(mid == -1){
            System.out.println("Not Found");
        }
        else{
            System.out.println("false");
        }
    }
}

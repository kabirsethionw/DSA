package JavaFiddle;

public class SearchInRotatedArrray {
    public static int search(int[] arr, int target){
        int top = SearchInRotatedArrray.searchMax(arr), left, right;
        if(top != -1 && top > 0 && top < arr.length -1){
            left = SearchInRotatedArrray.binarySearch(arr, 0, top -1, target);
            right = SearchInRotatedArrray.binarySearch(arr, top + 1, arr.length -1, target);
            if(arr[top] == target){
                return top;
            }
            else if(left != -1){
                return left;
            }
            else if(right != -1){
                return right;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int start, int end, int elem){
        int mid;
        while(start <= end){
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

    public static int binarySearchDesc(int[] arr, int start, int end, int elem){
        int mid;
        while(start <= end){
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

    public static int searchMax(int[] arr){
        int start = 0, end = arr.length -1, mid;

        while(start < end){
            mid = (start + end)/2;
            if(mid < 0 || mid > arr.length -1){
                return -1;
            };
            if(arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]){
                return mid;
            }
            else if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]){
                return mid -1;
            }
            else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                if (arr[mid] > arr[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = {4,5,6,7,8,0,1,2,3};
        System.out.println(SearchInRotatedArrray.search(test, 2));
    }
}

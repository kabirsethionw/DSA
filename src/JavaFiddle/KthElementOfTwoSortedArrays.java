package JavaFiddle;

public class KthElementOfTwoSortedArrays {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        int l1, l2, r1, r2, start = 0, end = 0, mid = k/2-1;
        if(n > m){
            int temp[] = arr1, t = n;
            arr1 = arr2;
            arr2 = temp;
            n = m; m = t;
        }
        end = n-1;
        while(true){
            l1 = mid < 0 ? Integer.MIN_VALUE : arr1[mid];
            l2 = k - mid - 2 < 0 ? Integer.MIN_VALUE : arr2[k - mid - 2];
            r1 = mid + 1 == n ? Integer.MAX_VALUE : arr1[mid + 1];
            r2 = k - mid - 1 == m ? Integer.MAX_VALUE : arr2[k - mid - 1];
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2);
            }
            else if(l1 > r2){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
            mid = (start + end)/2;
        }
    }
}

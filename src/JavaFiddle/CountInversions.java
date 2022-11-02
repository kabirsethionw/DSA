package JavaFiddle;

public class CountInversions {
    private static int inversionCount = 0;

    private static void merge(int arr[], int l, int mid, int r){
        int
                n = arr.length,
                temp[] = new int[n],
                ptrl = l,
                ptrr = mid + 1,
                ptrt = l;
        System.arraycopy(arr, 0, temp, 0, n);
        while(ptrl < mid + 1 && ptrr < r + 1){
            if(arr[ptrl] < arr[ptrr]){
                temp[ptrt++] = arr[ptrl++];
            }
            else{
                inversionCount += (mid+1 - ptrl);
                temp[ptrt++] = arr[ptrr++];
            }
        }

        while(ptrl < mid + 1){
            temp[ptrt++] = arr[ptrl++];
        }

        while(ptrr < r + 1){
            temp[ptrt++] = arr[ptrr++];
        }

        System.arraycopy(temp, 0, arr, 0, n);
    }

    public static void mergeSort(int[] arr, int l, int r){
        if(l == r) return;
        int half = (l+r)/2;
        mergeSort(arr, l, half);
        mergeSort(arr, half + 1, r);
        merge(arr, l, half, r);
    }

    public static void main(String[] args) {
        int[] test = {8, 4, 1, 2};
        mergeSort(test, 0,test.length-1);
        System.out.println(inversionCount);
        inversionCount = 0;
    }

}

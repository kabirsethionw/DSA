package JavaFiddle;

import java.util.ArrayList;
import java.util.HashMap;

public class TopKFrequentElements {
//    private static int myQuickSort(int arr[], int k){
//        int ptr1 = 0;
//        int ptr2 = arr.length-1;
//        while(true){
//            int loc = partition(arr, ptr1, ptr2);
//            if(loc == k) return k;
//            else if(loc < k) ptr1 = loc+1;
//            else ptr2 = loc-1;
//        }
//    }
//
//    private static int partition(int[] arr, int low, int high)
//    {
//        int pivot = low, ptr = high;
//        while(pivot < ptr){
//            while(arr[pivot] < arr[ptr] && pivot < ptr) ptr--;
//            if(pivot < ptr){
//                swap(arr, pivot, ptr);
//                int temp = pivot;
//                pivot = ptr; ptr = temp+1;
//            }
//            else return pivot;
//            while(arr[pivot] > arr[ptr] && pivot > ptr) ptr++;
//            if(pivot > ptr){
//                swap(arr, pivot, ptr);
//                int temp = pivot;
//                pivot = ptr; ptr = temp-1;
//            }
//            else return pivot;
//        }
//        return pivot;
//    }
//
//    private static void swap(int[] arr, int i, int j)
//    {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }

    private static int myQuickSort(ArrayList<MyPair> arr, int k){
        int ptr1 = 0;
        int ptr2 = arr.size()-1;
        while(true){
            int loc = partition(arr, ptr1, ptr2);
            if(loc == k) return k;
            else if(loc < k) ptr1 = loc+1;
            else ptr2 = loc-1;
        }
    }

    private static int partition(ArrayList<MyPair> arr, int low, int high)
    {
        int pivot = low, ptr = high;
        while(pivot < ptr){
            while((int)arr.get(pivot).value < (int)arr.get(ptr).value && pivot < ptr) ptr--;
            if(pivot < ptr){
                swap(arr, pivot, ptr);
                int temp = pivot;
                pivot = ptr; ptr = temp+1;
            }
            else return pivot;
            while((int)arr.get(pivot).value > (int)arr.get(ptr).value && pivot > ptr) ptr++;
            if(pivot > ptr){
                swap(arr, pivot, ptr);
                int temp = pivot;
                pivot = ptr; ptr = temp-1;
            }
            else return pivot;
        }
        return pivot;
    }

    private static void swap(ArrayList<MyPair> arr, int i, int j)
    {
        MyPair temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static int[] kTopFrequent(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.get(arr[i]) != null){
                int freq = map.get(arr[i]);
                map.put(arr[i], freq + 1);
            }
            else{
                map.put(arr[i], 1);
            }
        };
        ArrayList<MyPair> freqList = new ArrayList<>();
        for(int key: map.keySet()){
            freqList.add(new MyPair(key, map.get(key)));
        }

        int res[] = new int[k], ptr = 0;
        for(int i = freqList.size() - k; i < freqList.size(); i++){
            res[ptr++] = (int)freqList.get(myQuickSort(freqList, i)).key;
        }
        for(MyPair elem: freqList)
            System.out.println(elem.key + " " + elem.value);

        System.out.print("Answer:");
        for(int elem: res) System.out.print(" " + elem);
        return null;
    }

    public static void main(String[] args) {
                int[] testArr = {3,5,4,1,7,0,2,3,5,7,4,6,3,7,1,11,3,8,0,2,9,3,7,3,7,3,1};
        int k = 3;
        kTopFrequent(testArr, k);
    }
}

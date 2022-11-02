public class PeagonHoleSort {
    public static int[] phSort(int[] arr){
        int max = 0, min = Integer.MAX_VALUE, range, buckets[], ptr = 0, res[] = new int[arr.length];
        for(int elem: arr){ min = Math.min(min, elem); max = Math.max(max, elem); }
        range = max - min + 1; buckets = new int[range];
        for(int elem: arr){ buckets[elem - min]++; }
        for(int i = 0; i < buckets.length; i++){
            while(buckets[i]-- > 0) res[ptr++] = i + min;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] testArr = {2,5,4,9,7,11,1,11};
        for(int elem: phSort(testArr)){
            System.out.println(elem);
        };
    }
}

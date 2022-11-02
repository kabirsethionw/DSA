public class MaximumGap {
    public static int maxGap(int[] arr){
        int tmpArr[], maxDiff = 0, last;
        tmpArr = PeagonHoleSort.phSort(arr);
        last = tmpArr[0];
        for(int elem: tmpArr){
            maxDiff = Math.max(maxDiff, elem - last); last = elem;
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int testArr[] = {9, 7, 1, 4, 5, 2, 13, 20};
        System.out.println(maxGap(testArr));
    }
}

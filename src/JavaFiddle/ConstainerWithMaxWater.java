package JavaFiddle;

public class ConstainerWithMaxWater {
    public static int calculateMaxVol(int[] arr){
        int start = 0, end = arr.length -1, maxVol = 0;
        while(end != start){
            int vol = (end-start)*Math.min(arr[start], arr[end]);
            maxVol = maxVol < vol ? vol : maxVol;
            if(start > end)
                end--;
            else
                start++;
        }
        return maxVol;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(ConstainerWithMaxWater.calculateMaxVol(arr));
    }
}

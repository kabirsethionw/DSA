package JavaFiddle;

public class MedianOfTwoSortedArrays {
    public static int solution(int[] a, int[] b){
        int i = 0, j =0, start = 0, end = a.length -1, total = a.length + b.length;
        // TODO: Make a 'withinRange' function and add handling for i or j going out of range.
        while(start <= end && end > -1 && start < a.length - 1){
            i = (start + end)/2;
            j = total/2 - i - 2;

            if((j == b.length - 1|| a[i] <= b[j+1]) && (i == a.length || b[j] <= a[i+1]))
                if(total%2 == 0) return (Math.max(a[i], b[j]) + Math.min(a[i+1], b[j+1]))/2;
                else return Math.min(a[i+1], b[j+1]);
            else if(a[i] > b[j+1]) end = i-1;
            else if(b[j] > a[i+1]) start = i+1;
        }
        if(end == -1)
            if(a.length == total/2)
                if(total%2 == 0) return (a[a.length - 1] + b[0])/2;
                else return b[0];
            else{
                if(total%2 == 0) return (b[total/2 - a.length -1] + b[total/2 - a.length])/2;
                else return b[total/2 - a.length];
            }
        else if(start == a.length-1)
            if(b.length == total/2)
                if(total%2 == 0) return (b[b.length - 1] + a[0])/2;
                else return a[0];
            else{
                if(total%2 == 0) return (a[total/2 - b.length -1] + a[total/2 - b.length])/2;
                else return a[total/2 - b.length];
            }
        return -1;
    }

    public static void main(String[] args) { //1,3,4,6,7,11,14,19,22,27
        int testArr1[] = {1,3,4}, testArr2[] = {5,6,11,14,19};
        System.out.println(solution(testArr1, testArr2));
    }
}

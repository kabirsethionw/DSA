package JavaFiddle;

public class MinimumSumSequence {
    static int minSum(int arr[], int n){
//        if(n<=4)
//            return  min of arr[0-(n-1)];
        int a, b, c, d, e = 0;
        a = arr[0];
        b = arr[1];
        c = arr[2];
        d = arr[3];
        for(int i=4; i<n; i++){
            e = arr[i] + Math.min(a, Math.min(b, Math.min(c, d)));
            a = b;
            b = c;
            c = d;
            d = e;
        }
        return Math.min(a, Math.min(b, Math.min(c, Math.min(d, e))));
    }

    public static void main(String[] args) {
        int test[] = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(minSum(test, 8));
    }
}

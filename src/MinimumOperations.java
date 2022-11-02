public class MinimumOperations {
    public static int minimumOperations(int num){
        int n = num, ops = 0;
        if(n == 0) return 0;
        while(n != 0){
            if(n%2 == 0) n /= 2;
            else n--;
            ops++;
        }
        return ops;
    }

    public static void main(String[] args) {
        int test = 11;
        System.out.println(minimumOperations(test));
    }
}

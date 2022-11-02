public class MaximumProductCutting {
    public static int maxProd(int len){
        int dp[] = new int[len], maxVal = 0;
        for(int i = 1; i <= len; i++)
            for(int j = 1; j < i; j++){
                maxVal = Math.max(Math.max(maxVal, j*(i-j)), maxProd(i-j)*j);
            }
        return maxVal;
    }

    public static void main(String[] args) {
        System.out.println(maxProd(10));
    }
}

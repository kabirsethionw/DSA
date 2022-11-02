package JavaFiddle;

public class NoConsecutive1sAllowed {
    static long countStrings(int n) {
        // code here
//        int num = n;
//        int count = 0;
//        int msb = 0;
//        while(num!= 0){ num = num&(num-1); count++;}
//        num = n;
//        while(num != 0){ num = num >> 1; msb++;}
        long res = countHelper(n);
        return res;
    }

    static long countHelper(int len){
        int
                included[] = new int[len],
                not_included[] = new int [len];

        included[0] = 1;
        not_included[0] = 1;

        for(int i = 1; i < len; i++){
            not_included[i] = not_included[i-1] + included[i-1];
            included[i] = not_included[i-1];
        }

        return included[len-1] + not_included[len-1];
    }

    public static void main(String[] args) {
        System.out.println(countStrings(3));
    }
}
package JavaFiddle;

public class KMP {
    public static int find(String pattern, String string){
        int patternArr[] = prepareDpArr(pattern), ptrP = 0, ptrS = 0;
        while(ptrS < string.length()){
            if(string.charAt(ptrS) == pattern.charAt(ptrP)){
                ptrP++; ptrS++;
                if(ptrP == pattern.length()) return ptrS - pattern.length();
            }
            else{
                if(ptrP != 0) ptrP = patternArr[ptrP - 1];
                else ptrS++;
            }
        }
        return -1;
    }

    private static int[] prepareDpArr(String pattern){
        int ptr1 = 0 ,ptr2, dp[] = new int[pattern.length()];
        if(pattern.length() == 1) return new int[1];
        for(ptr2 = 1; ptr2 < pattern.length();){
            if(pattern.charAt(ptr1) == pattern.charAt(ptr2)) dp[ptr2++] = ptr1++ + 1;
            else if(ptr1 != 0) ptr1 = dp[ptr1-1];
            else dp[ptr2++] = 0;
        }
        return dp;
    }

    public static void main(String[] args) {
        String testPattern = "abcaby", testString = "abxabcabcaby";
            System.out.println(find(testPattern, testString));
    }
}

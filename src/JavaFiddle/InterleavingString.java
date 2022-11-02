package JavaFiddle;

public class InterleavingString {
    private static boolean dp [][];

    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        dp = new boolean[s1.length() + 1][ s2.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i < s1.length() + 1; i++)
            dp[i][0] = s1.charAt(i-1) == s3.charAt(i-1) ? dp[i-1][0] : false;
        for(int i = 1; i < s2.length() + 1; i++)
            dp[0][i] = s2.charAt(i-1) == s3.charAt(i-1) ? dp[0][i-1] : false;
        for(int i = 1; i < s1.length() + 1; i++){
            int ptr = i;
            for(int j = 1; j < s2.length() + 1; j++){
                dp[i][j] = (s1.charAt(i-1) == s3.charAt(ptr) && dp[i-1][j]) || (s2.charAt(j-1) == s3.charAt(ptr) && dp[i][j-1]);
                ptr++;
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String testStr1 = "db", testStr2 = "b", testStr3 = "cbb";
        System.out.println(isInterleave(testStr1, testStr2, testStr3));
    }
}

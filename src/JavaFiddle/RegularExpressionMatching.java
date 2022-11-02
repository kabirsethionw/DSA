package JavaFiddle;

public class RegularExpressionMatching {
    public static boolean isMatch(String pattern, String str){
        int
                n = str.length(),
                m = pattern.length();
        boolean dp[][] = new boolean[n+1][m+1];

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                char pChar = pattern.charAt(j-1), sChar = str.charAt(i-1);
                if((pChar == sChar|| pChar == '.') && dp[i-1][j-1]){// . and char
                    dp[i][j] = true;
                }
                else if(pChar == '*' && (dp[i][j-2] || sChar == pattern.charAt(j-2))){ // *
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String pattern = "xa*b.c", str = "xaabyc";
        System.out.println(isMatch(pattern, str));
    }
}

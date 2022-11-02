package JavaFiddle;

/**
 * Permitted operations - "." and "*"
 */
public class RegularExpressionsMatching {
    public static boolean solution(String word, String expression){
        boolean dp[][] = new boolean[word.length() + 1][expression.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i < word.length() + 1; i++){
            for(int j = 1; j < expression.length() + 1; j++){
                if((word.charAt(i-1) == expression.charAt(j-1) || expression.charAt(j-1) == '.') && dp[i-1][j-1]){
                    dp[i][j] = true;
                }
                else if(expression.charAt(j-1) == '*' && expression.charAt(j-2) == word.charAt(i-1)) {
                    dp[i][j] = true;
                }
                //else dp[i][j] = false;
            }
        }
        return dp[word.length()][expression.length()];
    }

    public static void main(String[] args) {
        String testWord = "xaabyc", testExp = "xa*b.c";
        System.out.println(solution(testWord, testExp));
    }
}

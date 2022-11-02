package JavaFiddle;

public class LongestPalindromicSubstring {
    public static int getLongestPalindromicSubstringLength(String word){
        if(word.isEmpty() || word.length() == 1) return word.length();

        int
                dp[][] = new int[word.length() + 1][word.length() + 1],
                n = word.length() + 1;

        dp[0][0] = 1; //Empty string is palindrome

        for(int i = 1; i < word.length() + 1; i++){
            for(int j = 1; j < word.length() + 1; j++){
                System.out.println(word.charAt(i-1) + " " + word.charAt(n-j-1));
                if(word.charAt(n-i-1) == word.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n-1][n-1];
    }

    public static void main(String[] args) {
        String testStr = "babad";
        System.out.println(getLongestPalindromicSubstringLength(testStr));
    }
}

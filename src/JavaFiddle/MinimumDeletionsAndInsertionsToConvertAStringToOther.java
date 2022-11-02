package JavaFiddle;

public class MinimumDeletionsAndInsertionsToConvertAStringToOther {
    //convert str1 to str2
    public static int solution(String str1, String str2){
        int m = str1.length(), n = str2.length(), dp[][], maxLen = 0;
        if(m > n){
            String tmp = str1;
            str1 = str2; str2 = tmp;
            m = str1.length(); n = str2.length();
        }
        dp = new int[m+1][n];
        for(int i = 1; i < m + 1; i++){
            for(int j = 0; j < n; j++){
                if(str1.charAt(i - 1) == str2.charAt(j)){
                    dp[i][j] = j == 0 ? 0 : dp[i-1][j-1] + 1;
                    maxLen = Math.max(dp[i][j], maxLen);
                }
            }
        }

        return str1.length() + str2.length() - 2*maxLen;
    }

    public static void main(String[] args) {
        String str1 = "aasdfcxzvxyzrt", str2 = "zvxyzp";
        System.out.println(solution(str1, str2));
    }
}

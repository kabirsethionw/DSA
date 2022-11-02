package JavaFiddle;

public class WordBreak {
    public static boolean breakWord(String[] dict, String word){
        boolean dp[] = new boolean[word.length() + 1], res;
        int ptr = word.length(), last = ptr;
        dp[ptr] = true;
        ptr--;
        while(ptr > -1){
            if(findString(dict, word.substring(ptr, last)) == -1){
                dp[ptr] = false;
            }
            else{
                dp[ptr] = true;
                last = ptr;
            }
            ptr--;
        }
        return dp[0];
    }

    public static int findString(String[] dict, String subStr){
        for(int i = 0; i < dict.length; i++){
            if(subStr.equals(dict[i])){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String testDict[] = {"leet","code"}, testWord = "leetcode";
        System.out.println(WordBreak.breakWord(testDict, testWord));
    }
}



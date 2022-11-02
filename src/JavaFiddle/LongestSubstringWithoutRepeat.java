package JavaFiddle;

public class LongestSubstringWithoutRepeat {
    static int longestSubstringWithoutRepeat(String s) {
        // add your logic here
        int
                map[] = new int[26],
                n = s.length(),
                l = -1,
                r = -1,
                len = 0,
                maxLen = 1;

        while(++r < n){
            map[s.charAt(r) - 'a']++; len++;
            if(map[s.charAt(r) - 'a'] > 1){
                while(map[s.charAt(r) - 'a'] > 1){
                    l++; len--;
                    map[s.charAt(l) - 'a']--;
                }
            }
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String test = "workattech";
        System.out.println(longestSubstringWithoutRepeat(test));
    }
}

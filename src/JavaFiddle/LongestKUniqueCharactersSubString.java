package JavaFiddle;

import java.util.HashMap;

public class LongestKUniqueCharactersSubString {
    public static int longestkSubstr(String s, int k) {
        // code here
        int max = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, n = s.length(), maxLen = 0;
        while(r < n){
            char curr = s.charAt(r);
            if(map.get(curr) == null){
                if(map.size() == k){
                    while(true){
                        char elem =  s.charAt(l++);
                        int count = map.get(elem);
                        if(count ==1){
                            map.remove(elem);
                            break;
                        }
                        map.put(elem, count - 1);
                    }
                }
                map.put(curr, 1);
            }
            else{
                int count = map.get(curr);
                map.put(curr, count + 1);
            }

            if(map.size() == k)
                max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        String testStr = "qwertyuioasdfghj"; int testK = 3;
        System.out.println(longestkSubstr(testStr, testK));
    }
}

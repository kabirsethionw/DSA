package JavaFiddle;

import java.util.HashMap;

public class MinWindowString {

    public static int findMinWindow(String s, String t){
        int left = -1, right = 0, count = t.length(), ptr = 0, minLength = s.length();
        String check = "right";
        boolean goAhead = true;
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(char alpha: t.toCharArray()){
            tMap.put(alpha, 1);
        }

        while(goAhead){
            while(count != 0 && check == "right" && right < s.length()){
                if(tMap.get(s.charAt(right)) != null){
                    if(left == -1)
                        left = right;
                    tMap.put(s.charAt(right), tMap.get(s.charAt(right)) - 1);
                    if(tMap.get(s.charAt(right)) == 0)
                        count--;
                }
                right++;
            }
//            if(right == s.length())
//                right--;
            if(count == 0){
                check = "left";
                minLength = minLength > right - left ? right - left : minLength;
            }

            while(count == 0 && check == "left"){
                if(tMap.get(s.charAt(left)) != null){
                    tMap.put(s.charAt(left), tMap.get(s.charAt(left)) + 1);
                    if(tMap.get(s.charAt(left)) == 1)
                        count++;
                }
                left++;
            }

            if(check == "left" && count != 0){
                minLength = minLength > right - left + 1 ? right - left + 1: minLength;
                if(right == s.length())
                    return minLength;
                check = "right";
            }

        }

        //System.out.println(tMap.get('G'));
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(MinWindowString.findMinWindow("ADOBECODEBANC", "ABC"));
    }
}

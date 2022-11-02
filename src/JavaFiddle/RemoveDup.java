package JavaFiddle;

import java.util.HashMap;

public class RemoveDup {

    public static char pop(StringBuilder sb){
        int len = sb.length();
        char c = '\u0000';
        String popped = new String();
        if(len > 0){
            popped = sb.substring(len-1);
            sb.delete(len-1, len);
            System.out.println(sb);
            c = popped.charAt(0);
        }
        return c;
    }

    public static void push(StringBuilder sb, char c){
        sb.append(c);
    }

    public static char peak(StringBuilder sb){
        int len = sb.length();
        char c = '\u0000';
        String peak = new String();
        if(len > 0){
            peak = sb.substring(len-1);
            c = peak.charAt(0);
        }
        return c;
    }

    public static String  removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Boolean> map = new HashMap();
        for(char elem: s.toCharArray()){
            if(map.get(elem) == null){
                while(sb.length() > 0 && Character.getNumericValue(peak(sb)) > Character.getNumericValue(elem)){
                    map.remove(pop(sb));
                }
                push(sb, elem);
                map.put(elem, true);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
    }
}

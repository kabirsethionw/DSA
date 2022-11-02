package JavaFiddle;

public class FirstRepeatingCharacter {
    public static char getFirstRepeatedChar(String str){
        int n = str.length();
        int bitVector = 0;
        char res = '\u0000';
        for(int i = 0; i < n; i++){
            char c = str.charAt(i);
            int val = 1<<( Character.valueOf(c) - Character.valueOf('a'));
            if((bitVector&val) != 0){
                res = c;
                break;
            }
            bitVector |= val;
        }
        return res;
    }

    public static void main(String[] args) {
        String test = "qwertuiiflcmx";
        System.out.println(getFirstRepeatedChar(test));
    }
}

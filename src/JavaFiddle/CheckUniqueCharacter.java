package JavaFiddle;

/**
 * @description Using bit vector, checks if all the characters are different in the string or not
 */
public class CheckUniqueCharacter {
    public static boolean isUnique(String str){
        int bitMap = 0;
        for(char c: str.toCharArray()){
            int val = c - 'a';
            if((bitMap & 1<<val) > 0){
                return false;
            }
            bitMap |= 1<<val;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("asfvfgop"));
    }
}

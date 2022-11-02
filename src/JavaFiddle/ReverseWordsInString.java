package JavaFiddle;

public class ReverseWordsInString {

    public static String reverse(String str){
        String[] strArr;
        int ptr = 0;
        str = str.trim().replaceAll("\\s+", " ");
        strArr = str.split(" ");
        while(ptr < (int)strArr.length/2){
            String temp = strArr[ptr];
            strArr[ptr] = strArr[strArr.length - 1 - ptr];
            strArr[strArr.length - 1 - ptr] = temp;
            ptr++;
        }
        return String.join(" ", strArr);
    }

    public static void main(String[] args) {
        String str = "a good   example";
        System.out.println(ReverseWordsInString.reverse(str));
    }
}

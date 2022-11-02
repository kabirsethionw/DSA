package JavaFiddle;

import java.util.Stack;

public class SimplifyPath {

    public static String simplify(String path){
        int ptr = 0; String folder = "";
        Stack<String> stack = new Stack<>();
        while(ptr < path.length()){
            String matchedExp = nextMove(path.substring(ptr));
            switch (matchedExp){
                case "../" : {
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    break;
                }
                case "//" : {
                    // do nothing
                }
                case "/" : {
                    if(!folder.equals("")) stack.push(folder);
                    folder = "";
                    break;
                }
                case "./" : {
                    break;
                }
                default:{
                    folder = path.substring(ptr, path.indexOf("/", ptr));
                }
            }
            int incr = matchedExp.length() != 0 ? matchedExp.length() : folder.length();
            ptr += incr;
        }
        String simplifiedPath = "";
        while(!stack.isEmpty()){
            simplifiedPath = "/" + stack.pop() + simplifiedPath;
        }
        return simplifiedPath;
    }


    private static String nextMove(String str){
        String possibleMoves[] = {"../", "//", "/", "./"};
        int ptr = 0; String found = "";
        while(ptr < possibleMoves.length && found == ""){
            if(str.indexOf(possibleMoves[ptr]) == 0) found = possibleMoves[ptr];
            ptr++;
        }
        return found;
    }

    public static void main(String[] args) {
        String str = "/../abc//./def/";
        System.out.println(simplify(str)); //str.substring(0,str.indexOf("/")) .indexOf( "../", 0)
    }
}

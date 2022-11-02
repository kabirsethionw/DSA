package JavaFiddle;

import java.util.ArrayList;
import java.util.Stack;

public class GenerateParanthesis {
    private static ArrayList<String> result = new ArrayList<>();

    public static String[] solution(int n){
        Stack stack = new Stack<>();
        stack.push('(');
        solutionHelper(1, n, stack, "(");
        return result.stream().toArray(String[]::new);
    }

    private static void solutionHelper(int count, int n, Stack stack, String str){

        if(count == 2*n){
            if(stack.isEmpty()) result.add(str);
        }
        else{
            Stack cpy1 = (Stack)stack.clone(), cpy2 = (Stack)stack.clone();
            cpy1.push('(');
            solutionHelper(count+1, n, cpy1, str + "(");
            if(!cpy2.isEmpty()) {
                cpy2.pop();
                solutionHelper(count+1, n, cpy2, str + ")");
            }
        }
    }

    public static void main(String[] args) {
        int test = 3;
        for(String ans: solution(test))
            System.out.println(ans);
    }
}

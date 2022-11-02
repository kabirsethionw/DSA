import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {
    private static List<String> allValidParenthesis = new ArrayList<>();

    public static List<String> generateParenthesis(int n){
        List<String> response;
        SolutionHelper(2*n, new Stack<Character>(), '(', "");
        SolutionHelper(2*n, new Stack<Character>(), ')', "");
        response = allValidParenthesis;
        allValidParenthesis = new ArrayList<>();
        return response;
    }

    /**
     *
     * @param n
     * @param stack
     * @param elem
     * @param parenthesis
     * @description if stack is empty and char is ')' then don't proceed through that branch.
     *  Otherwise pop from stack if char is ')' and push if char is '('.
     *  If parenthesis.length() == n and stack is empty then allValidParenthesis.
     */
    public static void SolutionHelper(int n, Stack<Character> stack, char elem, String parenthesis){

        if(parenthesis.length() == n){
            if(stack.isEmpty() && !allValidParenthesis.contains(parenthesis)){
                allValidParenthesis.add(parenthesis);
            }
        }
        else {
            boolean isConsidered = false;
            if (elem == ')' && !stack.isEmpty()) {
                stack.pop();
                isConsidered = true;
            } else if (elem == '(') {
                stack.push('(');
                isConsidered = true;
            }

            if(isConsidered){
                Stack<Character> tmp = new Stack<>();
                tmp.addAll(stack);
                SolutionHelper(n, stack, '(', parenthesis + elem);
                SolutionHelper(n, tmp, ')', parenthesis + elem);
            }
        }
    }

    public static void main(String[] args) {
        int testInput = 3;
        for(String validParenthesis: GenerateParenthesis.generateParenthesis(testInput)){
            System.out.println(validParenthesis);
        }
    }
}

package JavaFiddle;

import java.util.LinkedList;
import java.util.Stack;

public class Test001 {
    public static String smallestSubsequence(String s, int k, char letter, int repetition) {
        LinkedList<Character> ls = new LinkedList();
        Stack<Integer> stack = new Stack();
        int n = s.length(), count = 0, remaining = 0;
        for(int i = 0; i < n; i++) if(s.charAt(i) == letter) remaining++;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == letter){
                remaining--;
            }
            if(ls.size() == k){
                if(!stack.isEmpty()){
                    int loc = stack.pop();
                    if(s.charAt(loc) != letter || repetition - count <= remaining)
                        ls.remove(loc);
                    if(loc > 0 && ls.get(loc) < ls.get(loc-1)) stack.push(loc-1);
                }
                else if(s.charAt(i) == letter && count < repetition){
                    int ptr = k-1;
                    while(ls.get(ptr) == letter) ptr--;
                    ls.remove(ptr);
                    if(ptr < ls.size() && ls.get(ptr) < ls.get(ptr-1)) stack.push(ptr-1);
                }
            }
            if(ls.size() < k){
                ls.add(s.charAt(i));
                if(s.charAt(i) == letter) count++;
                if(ls.size() > 1 && ls.get(ls.size()-1) < ls.get(ls.size()-2)){
                    stack.push(ls.size()-2);
                }
            }

        }
        String res = new String();
        for(char elem: ls){
            res = res + elem;
        }
        return res;
    }

    public static void main(String[] args) {
        smallestSubsequence("leetcode", 4, 'e', 2);
    }
}

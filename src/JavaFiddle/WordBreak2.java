package JavaFiddle;

import java.util.ArrayList;
import java.util.List;

class WordBreak2 {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        ArrayList<String> queue = new ArrayList<>();
        List<String> res = new ArrayList<>();
        for(String w: wordDict){
            if(s.indexOf(w) == 0)
                queue.add(w);
        }
        System.out.println(queue);
        while(queue.size() > 0){
            ArrayList<String> queue2 = new ArrayList<>();
            for(String e: queue){
                String elem = e.replaceAll(" ", "");
                for(String w: wordDict){
                    if(s.substring(elem.length()).indexOf(w) == 0){
                        boolean con = (elem+w).length() == s.length();
                        System.out.println("(elem+w).length() == s.length() "+ con);
                        if(con)
                            res.add(e + " " + w);
                        else
                            queue2.add(e +" "+ w);
                        System.out.println(e+" "+w);
                    }
                }
            }
            queue = queue2;
            System.out.println("q "+queue);
            System.out.println("res "+res);
        }
        return res;
    }

    public static void main(String[] args) {
        String testStr = "pineapplepenapple";
        ArrayList<String> testList = new ArrayList<>();
        testList.add("apple"); testList.add("pen");  testList.add("applepen"); testList.add("pine");  testList.add("pineapple");

        WordBreak2.wordBreak(testStr, testList);
    }
}
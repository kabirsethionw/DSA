package JavaFiddle;

import java.util.HashMap;

class BullsAndCows {
    public static String getHint(String secret, String guess) {
        //1123590 1925940 3A2B
        int cows = 0, bulls = 0, length = secret.length();
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> cMap = new HashMap<>();
        for(int i = 0; i < length; i++){
            char s, c;
            s = secret.charAt(i);
            c = guess.charAt(i);
            if(c == s) {
                System.out.println("Match");
                bulls++;
                continue;
            }

            if(sMap.get(c) != null){
                cows++;
                int count = sMap.get(c);
                System.out.println("cow c "+ (count -1) + " "+ c+ " count"+ count);
                System.out.println("check "+(sMap.get(c) == 1));
                if(count == 1) {
                    sMap.remove(c);
                    System.out.println("gggg" + sMap.get(c));
                }
                else
                    sMap.put(c, count-1);
                System.out.println("check "+sMap.get(c));
            }
            else{
                int countx = cMap.get(c) == null ? 0 : cMap.get(c);
                System.out.println("put c "+ (countx+1) + " "+ c);
                cMap.put(c, countx + 1);
            }

            if(cMap.get(s) != null){
                cows++;
                int count = cMap.get(s);
                System.out.println("cow s "+ (count -1)+ " "+ s+ " count"+ count);
                System.out.println("check "+(cMap.get(s) == 1));
                if(count == 1) {
                    cMap.remove(s);
                }
                else
                    cMap.put(s, count-1);
                System.out.println("check "+sMap.get(s));
            }
            else{
                int countx = sMap.get(s) == null ? 0 : sMap.get(s);
                System.out.println("put s "+ (countx+1) + " "+ s);
                sMap.put(s, countx + 1);
            }

        }
        return bulls+"A"+cows+"B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("2962", "7236"));
    }
}
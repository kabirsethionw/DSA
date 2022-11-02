package JavaFiddle;

import java.util.HashMap;

public class DecodeWays {
    public static int numDecodings(String s) {
        {
            HashMap<String, String> map = new HashMap<>();
            int dp[] = new int[s.length()];
            for(int i = 1; i <= 26; i++) {
                map.put(i + "", String.valueOf((char) (64 + i)));
            }
            if(s.isEmpty()) return 0;
            if(s.length() == 1){
                if(map.get(s) != null) return 1;
                else return 0;
            }
            dp[0] = map.get(s.substring(0, 1)) != null ? 1 : 0;
            if(dp[0] == 0) return 0;
            if(s.length() > 1){
                if(map.get(s.substring(1, 2)) != null && map.get(s.substring(0, 2)) != null) dp[1] = 2;
                else if(map.get(s.substring(1, 2)) != null || map.get(s.substring(0, 2)) != null) dp[1] = 1;
                for(int i = 2; i < s.length(); i++){
                    if(dp[i-1] != 0){
                        if(map.get(s.substring(i, i+1)) != null && map.get(s.substring(i-1, i+1)) != null) dp[i] = dp[i-1] + dp[i-2];
                        else if(map.get(s.substring(i, i+1)) != null) dp[i] = dp[i-1];
                        else if(map.get(s.substring(i-1, i+1)) != null) dp[i] = dp[i-2];
                    }
                }
            }
            for(int elem: dp) System.out.print(elem+ " ");
            return dp[dp.length-1];
        }
    }

    public static void main(String[] args) {
        String test = "1120";
        System.out.println(numDecodings(test));
    }
}

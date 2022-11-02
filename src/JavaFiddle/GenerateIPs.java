package JavaFiddle;

import java.util.ArrayList;
import java.util.Arrays;

public class GenerateIPs {
    public static ArrayList<String> generate(String ip){
        ArrayList<String> res = new ArrayList<>();
        helper(ip, 0, ip.length() - 1, 1, "", res);
        return res;
    }

    private static void helper(String ip, int ptr, int n, int level, String temp,ArrayList<String> ips){

        if(level == 5 && ptr == (n + 1)){
            ips.add(temp.substring(1));
        }
        for(int i = ptr; i < i + 3 && i <= n; i++){
            String subStr = ip.substring(ptr, i+1);
            int sub = Integer.parseInt(subStr);
            if((subStr.charAt(0) == '0' && subStr.length() > 1) || sub > 255){
                return;
            }
            helper(ip, i+1, n, level+1, temp + "." + subStr, ips);
        }
    }

    public static void main(String[] args) {
        String test = "25525511135";
        ArrayList<String> ans = generate(test);
        for(String ip: ans){
            System.out.print(ip+" ");
        }
    }
}

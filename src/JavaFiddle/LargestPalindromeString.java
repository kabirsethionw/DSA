package JavaFiddle;

import java.util.ArrayList;

public class LargestPalindromeString {
    public static String highestValuePalindrome(String s, int n, int k) {
    // Write your code here
    if(n == 0 || k == 0 || s == null) return "-1";
    ArrayList<ArrayList<Integer>> diffIndexes = new ArrayList<>();
    char[] sArr = s.toCharArray();
    int l = 0, r = n-1, diffCount = 0;

    while(l < r){
        if(sArr[l] != sArr[r]){
            diffCount++;
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(l);
            pair.add(r);
            diffIndexes.add(pair);
        }
    }

    if(diffCount > k) return "-1";

    for(int i = 0; i < diffIndexes.size(); i++){
        int lp = diffIndexes.get(i).get(0), rp = diffIndexes.get(i).get(1);
        if(k > diffCount){
            k -=2;
            diffCount -=1;
            sArr[lp] = '9'; sArr[rp] = '9';
        }
        else{
            k -=1;
            diffCount -=1;
            if(sArr[lp] - '0' > sArr[rp] - '0'){
                sArr[rp] = sArr[lp];
            }
            else{
                sArr[lp] = sArr[rp];
            }
        }
    }
    int ptr = -1;
    while(k > 1) {
        ptr++;
        if(sArr[ptr] == '9') continue;
        sArr[ptr] = '9'; sArr[n - 1 - ptr] = '9';
        k -= 2;
    }

    if(k == 1 && n%2 != 0){
        sArr[n/2] = '9';
    }

    return String.valueOf(sArr);
}

    public static void main(String[] args) {
        String test = "1231";
        int k = 1;
        System.out.println();
    }
}

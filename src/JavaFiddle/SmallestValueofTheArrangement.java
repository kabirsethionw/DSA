package JavaFiddle;

import java.util.ArrayList;
import java.util.Collections;

public class SmallestValueofTheArrangement   {

    private static MyPair<Integer, ArrayList<Integer>> getDigitArray(long num){
        int
                n = String.valueOf(num).length(),
                zeroCount = 0;
        long rem = num;
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0; i < n; i++){
            int digit = (int)rem%10;
            rem = rem/10;
            if(digit == 0) zeroCount++;
            list.add(digit);
        }
        return new MyPair<Integer, ArrayList<Integer>>(zeroCount,list);//list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void swap(ArrayList<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static long smallestNumber(long num) {
        MyPair<Integer, ArrayList<Integer>> pair = null;
        ArrayList<Integer> digits = null;
        StringBuilder str = new StringBuilder();
        if(num > 0){
            pair = getDigitArray(num);
            digits = pair.value;
            int zeroCount = pair.key;
            Collections.sort(digits, (t1, t2) -> Integer.signum(t1.intValue() - t2.intValue()));
            if(zeroCount > 0) swap(digits, 0, zeroCount);
        }
        else{
            long absVal = Math.abs(num);
            pair = getDigitArray(absVal);
            digits = pair.value;
            Collections.sort(digits, (t1, t2) -> Integer.signum(t2.intValue() - t1.intValue()));
            str.append("-");
        }
        for(Integer elem: digits){
            str.append(elem);
        }

        return Long.parseLong(str.toString());
    }

    public static void main(String[] args) {
        smallestNumber(-507l);
    }
}
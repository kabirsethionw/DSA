package JavaFiddle;

import java.util.HashMap;

public class IntegerToRoman {
    public static String intToRoman(int num) {
        HashMap<Integer, String> lookupTable = new HashMap<Integer, String>();
        lookupTable.put(1, "i");
        lookupTable.put(2, "ii");
        lookupTable.put(3, "iii");
        lookupTable.put(4, "iv");
        lookupTable.put(5, "v");
        lookupTable.put(6, "vi");
        lookupTable.put(7, "vii");
        lookupTable.put(8, "viii");
        lookupTable.put(9, "ix");
        String
                factor[][] = {
                    {"I", "V", "X"},
                    {"X", "L", "C"},
                    {"C", "D", "M"},
                    {"M", "", ""}
                },
                result = "";

        int n = String.valueOf(num).length(), tempNum = num;

        for(int i = 0; i < n; i++){
            int dig = tempNum%10;
            tempNum /= 10;
            String digRom = lookupTable.get(dig);
            digRom = digRom.replaceAll("i", factor[i][0]);
            digRom = digRom.replaceAll("v", factor[i][1]);
            digRom = digRom.replaceAll("x", factor[i][2]);
            result = digRom + result;
        }

        return result;
    }

    public static void main(String[] args) {
        int test = 1994;
        System.out.println(intToRoman(test));
    }
}

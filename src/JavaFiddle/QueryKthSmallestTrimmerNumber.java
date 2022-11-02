//package JavaFiddle;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import javafx.util.Pair; // not found
//
//public class QueryKthSmallestTrimmerNumber {
//    private static HashMap<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
//
//    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
//        int res[] = new int[queries.length];
//        for(int i = 0; i < queries.length; i++){
//            res[i] = getAns(nums, queries[i][1], queries[i][0]);
//        }
//        return res;
//    }
//
//    private static <Pair> int getAns(String[] nums, int digits, int k){
//        if(map.get(digits) != null) return map.get(digits).get(k-1).getValue();
//
//        int
//                divisor = (int)Math.pow(10, digits);
//        List<Pair<Integer, Integer>> list = new ArrayList<>();
//        for(int i = 0; i < nums.length; i++){
//            int trimmed = Integer.parseInt(nums[i])%divisor;
//            list.add(new Pair<Integer, Integer>(trimmed, i));
//        }
//
//        Collections.sort(list, (n1, n2) -> {
//            if(n1.getKey() == n2.getKey()){
//                System.out.println("hello");
//                return n1.getValue() - n2.getValue();
//            }
//            else{
//                return n1.getKey().compareTo(n2.getKey());
//            }
//        });
//
//        map.put(digits, list);
//        return list.get(k-1).getValue();
//    }
//}



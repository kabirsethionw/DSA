package JavaFiddle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @description Given a target number and an array of numbers, return an array of arrays where each arra contains
 * numbers that add up to be equal to the target sum
 */
public class HowSum {
//    private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//
//    public static void solution(int[] nums, ArrayList<Integer> selectedNums, int sum){
//        if(sum == 0) result.add(selectedNums);
//        if(sum < 0) return;
//
//        for(int elem: nums){
//            ArrayList<Integer> selecteedNumsCopy = (ArrayList<Integer>) selectedNums.clone();
//            selecteedNumsCopy.add(elem);
//            solution(nums, selecteedNumsCopy, sum - elem);
//        }
//    }

    private static HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();

    public static ArrayList<ArrayList<Integer>> solution(int[] nums, int sum){
        if(map.containsKey(sum)) return map.get(sum);
        if(sum == 0) return new ArrayList<>();
        if(sum < 0) return null;
        ArrayList<ArrayList<Integer>> localResult = new ArrayList<>();
        for(int elem: nums){
            ArrayList<ArrayList<Integer>> subResult = solution(nums, sum - elem);
            if(subResult != null) {
                Collections.copy(subResult, subResult); // Need deep copy
                if(subResult.isEmpty()){
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(elem);
                    subResult.add(tempList);
                }
                else{
                    for(ArrayList<Integer> list: subResult)
                        list.add(elem);
                }
                localResult.addAll(subResult);
            }
        }
        localResult = localResult.isEmpty() ? null : localResult;
        map.put(sum, localResult);
        return localResult;
    }

    public static void main(String[] args) {
        int testArr[] = {2, 3, 5}, testTarget = 8;
        for(ArrayList<Integer> list: solution(testArr, testTarget)) {
            System.out.print("[");
            for (int elem : list)
                System.out.print(" "+elem);
            System.out.println(" ]");
        }
    }
}

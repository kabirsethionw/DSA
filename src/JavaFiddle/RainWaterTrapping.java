package JavaFiddle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RainWaterTrapping {
    public static int calcVol(int[] arr){
        ArrayList<Integer> levelVol = new ArrayList<>();
        ArrayList<Integer> counterList = new ArrayList<>();
        int pointer = 0, counterLen = 0;
        System.out.println("hello "+Arrays.stream(arr).reduce((i1, i2) -> i1 + i2).getAsInt());
        while(pointer != arr.length -1){
                int spaceIncr = arr[pointer] - levelVol.size();
                if(spaceIncr > 0){
                    levelVol.addAll(Arrays.stream(new int[spaceIncr]).boxed().collect(Collectors.toList()));
                    counterList.addAll(Arrays.stream(new int[spaceIncr]).boxed().collect(Collectors.toList()));
                }
                for(int i = levelVol.size(); levelVol.size() > 0 && i > arr[pointer]; i--){
//                    levelVol.set(i-1 , counterList.get(i-1));
                    counterList.set(i-1, counterList.get(i-1).intValue() + 1);
                }
                for(int i = 0; levelVol.size() > 0 && i < arr[pointer]; i++){
                    levelVol.set(i , levelVol.get(i).intValue() + counterList.get(i).intValue());
                    counterList.set(i, 0);
                }
            pointer++;
        }
        System.out.println(levelVol.toString());
        return levelVol.stream().mapToInt(Integer::intValue).reduce(0, Integer::sum);
    }
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(RainWaterTrapping.calcVol(arr));
    }
}

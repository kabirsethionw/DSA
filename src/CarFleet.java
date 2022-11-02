import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        List<List<Integer>> entries= new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < position.length; i++){
            List<Integer> entry = new ArrayList<>();
            entry.add(position[i]); entry.add(speed[i]);
            entries.add(entry);
        }
        entries = entries.stream().sorted(Comparator.comparingInt(x -> x.get(0))).collect(Collectors.toList());
        for(int i = 0; i < entries.size(); i++){
            int time = (target - entries.get(i).get(0).intValue())*entries.get(i).get(0).intValue();
            if(!stack.isEmpty() && time <= stack.peek()){
                stack.pop();
            }
            stack.push(time);
        }

        return stack.size();
    }
}

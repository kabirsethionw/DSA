package JavaFiddle;

public class ArrayPairSumDivisible {
    public boolean canPair(int[] nums, int k) {
        // Code here
        int rems[] = new int[k];
        for(int elem: nums) rems[elem%k]++;
        for(int i = 0; i < k; i++){
            if(i == 0 && rems[i]%2 != 0) return false;
            if(i != 0 && rems[i] != rems[k-i]) return false;
        }
        return true;
    }
}

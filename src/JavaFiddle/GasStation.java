package JavaFiddle;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int[][] table = new int[gas.length][gas.length];
        for(int i = 0; i < gas.length; i++){
            table[0][i] = gas[i] - cost[i];
        }

        for(int i = 1; i < gas.length; i++)
            for(int j = 0; j < gas.length; j++){
                if(table[i-1][j] < 0)
                    table[i][j] = -1;
                else
                table[i][j] = table[i-1][j] + gas[(i+j-1)% gas.length] + cost[(i+j-1)% gas.length];
            }

        for(int i = 0; i < gas.length; i++){
            if(table[gas.length -1][i] > -1)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] testGas = {1,2,3,4,5}, testCost = {3,4,5,1,2};
        System.out.println(GasStation.canCompleteCircuit(testGas, testCost));
    }
}

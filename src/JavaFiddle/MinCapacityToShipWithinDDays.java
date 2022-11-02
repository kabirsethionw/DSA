package JavaFiddle;

class MinCapacityToShipWithinDDays {
    
    public static boolean checkCompletionDays(int[] weights, int days, int capacity){
        int sum = 0, daysCount = 1;
        for(int i = 0; i < weights.length; i++){
            if(weights[i] + sum <= capacity){
                sum += weights[i];
            }
            else{
                if(weights[i] <= capacity){
                    sum = weights[i];
                    daysCount++;
                }
                else{
                    return false;
                }
            }
        }

        return daysCount <= days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int lower = 0, upper =0, mid = 0, ans = 0; 
        for(int i = 0; i < weights.length; i++){
            upper += weights[i];
        }
        while(lower <= upper){
            mid = (lower+upper)/2;
            if(MinCapacityToShipWithinDDays.checkCompletionDays(weights, days, mid)){
                ans = mid;
                upper = mid -1;
            }
            else{
                lower = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int testArray[] = {1,2,3,4,5,6,7,8,9,10}, days = 5;
        System.out.println(MinCapacityToShipWithinDDays.shipWithinDays(testArray, days));
    }
}
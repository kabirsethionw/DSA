class CarrPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int
                sortedTrips[][] = new int[1001][3],
                totalTrips = trips.length,
                lastDest = 0,
                tripCount = 0,
                currCapacity = 0;

        //Arrays.fill(sortedTrips,);
        for(int[] trip: trips){
            sortedTrips[trip[1]] = trip;
            sortedTrips[trip[2]] = new int[]{-trip[0], trip[1], trip[2]};
        }

        for(int i = 0; i < 1001 && tripCount < totalTrips; i++){
            System.out.println(sortedTrips[i][0] + " " + sortedTrips[i][1] + " " + sortedTrips[i][2]);
            if(sortedTrips[i][0] != 0){

                if(sortedTrips[i][1] < lastDest){
                    currCapacity += sortedTrips[i][0];
                }
                else if(sortedTrips[i][1] >= lastDest){
                    currCapacity = sortedTrips[i][0];
                }
                System.out.println("i "+ i + ", currCap " + currCapacity);
                if(currCapacity > capacity)
                    return false;

                lastDest = lastDest < sortedTrips[i][2] ? sortedTrips[i][2] : lastDest;
                tripCount++;
            }
        }
        return true;
    }
}
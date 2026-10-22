package Greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tank = 0;
        int startIdx = 0;
        int total = 0;
        for(int i=0;i<n;i++){
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;

            if(tank < 0){
                startIdx = i+1;
                tank = 0;
            }
        }

        return total >=0 ? startIdx : -1;

    }
}

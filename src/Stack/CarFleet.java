package Stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//target=10
//position=[4,1,0,7]
//speed=[2,2,1,1]


public class CarFleet {
//    public static int carFleet(int target, int[] position, int[] speed) {
//        int n = position.length;
//        Set<Integer> set = new HashSet<>();
//        for(int i =0;i<n;i++){
//            int s = speed[i];
//            int p = position[i];
//            int x = 0;
//            while(p != target){
//                x++;
//                p += s;
//                if(p >= target){
//                    set.add(x);
//                    break;
//                }
//            }
//        }
//        return set.size();
//    }





    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Store position + time to reach target
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        // Sort by position (nearest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double maxTime = 0;

        for (int i = 0; i < n; i++) {
            double currTime = cars[i][1];

            // Greedy decision
            if (currTime > maxTime) {
                fleets++;
                maxTime = currTime;
            }
            // else: merges into existing fleet
        }

        return fleets;
    }

    public static void main(String[] args) {
//        int[] pos = {4,1,0,7};
//        int[] speed = {2,2,1,1};
//        int[] pos = {1,4};
//        int[] speed = {3,2};
        //        int x = carFleet(10,pos,speed);

        int[] pos = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};


        int x = carFleet(12,pos,speed);
        System.out.println(x);
    }
}

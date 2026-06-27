package Stack;

import java.util.*;

//target=10
//position=[4,1,0,7]
//speed=[2,2,1,1]


public class CarFleet {
    //check this solution
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




    //T.C -> O(nlogn)
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

//         Store position + time to reach target
        double[][] carsAndPos = new double[n][2];
        for (int i = 0; i < n; i++) {
            carsAndPos[i][0] = position[i];
            carsAndPos[i][1] = (double)(target - position[i]) / speed[i];
        }
        // Sort by position (nearest to target first)
        Arrays.sort(carsAndPos, (a, b) -> Double.compare(b[0], a[0]));
        int fleets = 0;
        double lastFleetTime = 0;
        for (int i = 0; i < n; i++) {
            double currTime = carsAndPos[i][1];
            // Greedy decision
            if (currTime > lastFleetTime) {
                fleets++;
                lastFleetTime = currTime;
            }
            // else: merges into existing fleet
        }
        return fleets;
    }

    //wrong bcz road is single lane , not multi lane, so a fast car that is behind of a slow car can't pass through, when the fast car reaches the slow car, the fast car also need to go as the same speed of that slow car
//    public static int carFleet(int target, int[] position, int[] speed) {
//        int n = position.length;
//        Set<Double> carFleets = new HashSet<>();
//        for(int i =0;i<n;i++){
//            int requiredDistance = target - position[i];
//            Double time = (double) (requiredDistance/speed[i]);
//            carFleets.add(time);
//        }
//        return carFleets.size();
//    }


    //Using stack, but it is same as the original solution
//    public int carFleet(int target, int[] position, int[] speed) {
//        int n = position.length;
//
//        // Store (position, speed)
//        int[][] cars = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            cars[i][0] = position[i];
//            cars[i][1] = speed[i];
//        }
//
//        // Sort cars by position (ascending)
//        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));
//
//        Stack<Double> stack = new Stack<>();
//
//        // Traverse from the car closest to the target
//        for (int i = n - 1; i >= 0; i--) {
//            double time = (double) (target - cars[i][0]) / cars[i][1];
//
//            // New fleet if this car takes longer than the fleet ahead
//            if (stack.isEmpty() || time > stack.peek()) {
//                stack.push(time);
//            }
//            // Otherwise, it joins the fleet ahead (do nothing)
//        }
//
//        return stack.size();
//    }




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

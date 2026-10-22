package Greedy;

import java.util.*;

public class MergeTipletsToFormTargets {

    //Approach I , T.c->O(n),A.S->O(n)
//    public boolean mergeTriplets(int[][] triplets, int[] target) {
//        List<int[]> list = new ArrayList<>();
//
//        for (int[] triplet : triplets) {
//            list.add(triplet);
//        }
//
//        list.removeIf(t ->
//                t[0] > target[0] ||
//                        t[1] > target[1] ||
//                        t[2] > target[2]
//        );
//
//        boolean[] flag = new boolean[3];
//        for (int i = 0; i < 3; i++) {
//            for (int[] t : list) {
//                if (t[i] == target[i])
//                    flag[i] = true;
//            }
//        }
//
//        return (flag[0] && flag[1] && flag[2]);
//    }

    //Approach II , T.c->O(n),A.S->O(1)
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] flag = new boolean[3];

        for (int[] t : triplets) {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2])
                continue;

            for (int i = 0; i < 3; i++) {
                if (t[i] == target[i])
                    flag[i] = true;
            }
            if (flag[0] && flag[1] && flag[2])
                return true;
        }

        return false;
    }
}

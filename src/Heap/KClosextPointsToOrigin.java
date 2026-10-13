package Heap;


import java.util.*;
public class KClosextPointsToOrigin {
//    public int[][] kClosest(int[][] points, int k) {
//        Map<Integer,List<int[]>> map = new HashMap<>();
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//
//        for(int[] point: points){
//            int dist = (point[0]*point[0])+(point[1]*point[1]);
//            if (!map.containsKey(dist)) {
//                minHeap.add(dist);
//            }
//            map.computeIfAbsent(dist, x-> new ArrayList<>()).add(point);
//        }
//        int[][] ans = new int[k][2];
//        int index = 0;
//
//        while(index < k){
//            int dist = minHeap.poll();
//            for(int[] point : map.get(dist)){
//                ans[index++] = point;
//                if(index == k) break;
//            }
//        }
//        return ans;
//    }


    //using maxHeap
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] ans = new int[k][];
        for (int i = 0; i < k; i++) {
            ans[i] = maxHeap.poll();
        }
        return ans;
    }


    //Using minheap
//    public int[][] kClosest(int[][] points, int k) {
//        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
//                (a, b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1])
//        );
//
//        for (int[] point : points) {
//            minHeap.add(point);
//        }
//
//        int[][] ans = new int[k][];
//        for (int i = 0; i < k; i++) {
//            ans[i] = minHeap.poll();
//        }
//        return ans;
//    }
}

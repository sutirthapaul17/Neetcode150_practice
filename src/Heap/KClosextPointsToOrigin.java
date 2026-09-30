package Heap;


import java.util.*;
public class KClosextPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        Map<Integer,List<int[]>> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int[] point: points){
            int dist = (point[0]*point[0])+(point[1]*point[1]);
            if (!map.containsKey(dist)) {
                minHeap.add(dist);
            }
            map.computeIfAbsent(dist, x-> new ArrayList<>()).add(point);
        }
        int[][] ans = new int[k][2];
        int index = 0;

        while(index < k){
            int dist = minHeap.poll();
            for(int[] point : map.get(dist)){
                ans[index++] = point;
                if(index == k) break;
            }
        }
        return ans;
    }
}

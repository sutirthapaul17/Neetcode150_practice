package Heap;

import java.util.*;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : stones){
            maxHeap.offer(ele);
        }

        while(maxHeap.size() > 1){
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if(x == y) maxHeap.offer(0);
            else maxHeap.offer(y-x);
        }
        return maxHeap.peek();

    }
}

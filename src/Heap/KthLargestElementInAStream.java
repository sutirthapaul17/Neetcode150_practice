package Heap;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int k;
    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        for(int ele : nums ) {
            minHeap.add(ele);
            if(minHeap.size()>k)
                minHeap.remove();
        }
    }

    public int add(int val) {
        if (minHeap.size() < k || val > minHeap.peek()) {
            minHeap.offer(val);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
}

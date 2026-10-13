package Heap;
import java.util.*;

public class KthLargestElementInAnArray {
    //m-1
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        for(int i=0;i<nums.length;i++){
//            minHeap.add(nums[i]);
//        }
//        while(minHeap.size()>k){
//            minHeap.poll();
//        }
//        return minHeap.peek();
//    }


    //M-2
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//
//        for(int i=0;i<nums.length;i++){
//            minHeap.add(nums[i]);
//            while(minHeap.size() > k){
//                minHeap.remove();
//            }
//        }
//
//        return minHeap.peek();
//    }

    //M-3(Best solution)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0;i<nums.length;i++){
            if(minHeap.size() < k){
                minHeap.add(nums[i]);
            }else if(nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        return minHeap.peek();
    }
}

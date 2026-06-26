package SlidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    //Brute force -> 0(n*k)
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if(nums.length < k) return nums;
//        int left = 0;
//        int max = Integer.MIN_VALUE;
//        ArrayList<Integer> arr = new ArrayList<>();
//        for(int right = k-1;right < nums.length;right++){
//            int i = left;
//            max = Integer.MIN_VALUE;
//            while(i<right+1){
//                max = Math.max(nums[i], max);
//                i++;
//            }
//            arr.add(max);
//            left++;
//        }
//        int[] ans = new int[arr.size()];
//        for(int i = 0;i < arr.size();i++){
//            ans[i] = arr.get(i);
//        }
//        return ans;
//    }

    public int[] maxSlidingWindow(int[] arr, int k) {
        ArrayList<Integer> nums = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            while(!dq.isEmpty() && dq.getFirst() <= i-k){ // Out of Window
                dq.removeFirst();
            }
            while(!dq.isEmpty() && arr[dq.getLast()] <= arr[i]){ // Removing Smaller values
                dq.removeLast();
            }
            dq.addLast(i);
            if(i >= k-1) nums.add(arr[dq.getFirst()]);
        }
        int[] ans = new int[nums.size()];
        for(int i = 0;i < nums.size();i++){
            ans[i] = nums.get(i);
        }
        return ans;
    }


}

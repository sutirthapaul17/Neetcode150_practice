package Greedy;

public class MaximumSubarray {

    //Brute force->TLE
//    public int maxSubArray(int[] nums) {
//        int best = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                best = Math.max(best, sum);
//            }
//        }
//        return best;
//    }


    //Greedy Approach,Kadanes algo
    public int maxSubArray(int[] nums) {
        int sum =0;
        int maxSum = Integer.MIN_VALUE;
        for(int x : nums){
            sum+=x;
            maxSum = Math.max(sum,maxSum);
            if(sum < 0) sum =0;
        }
        return maxSum;
    }


    //Prefix sum
//    public int maxSubArray(int[] nums) {
//        int prefix = 0;
//        int minPrefix = 0;
//        int best = Integer.MIN_VALUE;
//
//        for (int x : nums) {
//            prefix += x;
//            best = Math.max(best, prefix - minPrefix);
//            minPrefix = Math.min(minPrefix, prefix);
//        }
//        return best;
//    }


    //Divide and conquor
//    public int maxSubArray(int[] nums) {
//        return solve(nums, 0, nums.length - 1);
//    }
//
//    private int solve(int[] nums, int lo, int hi) {
//        if (lo == hi) return nums[lo];
//
//        int mid = lo + (hi - lo) / 2;
//        int leftBest = solve(nums, lo, mid);
//        int rightBest = solve(nums, mid + 1, hi);
//
//        // best sum crossing the midpoint
//        int sum = 0, leftCross = Integer.MIN_VALUE;
//        for (int i = mid; i >= lo; i--) {
//            sum += nums[i];
//            leftCross = Math.max(leftCross, sum);
//        }
//        sum = 0;
//        int rightCross = Integer.MIN_VALUE;
//        for (int i = mid + 1; i <= hi; i++) {
//            sum += nums[i];
//            rightCross = Math.max(rightCross, sum);
//        }
//
//        return Math.max(Math.max(leftBest, rightBest), leftCross + rightCross);
//    }
}

package Greedy;

public class JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int maxPos = 0;
        int jump = 0;
        int currEnd = 0;
        for(int i=0;i<n;i++){
            maxPos = Math.max(maxPos,i+nums[i]);
            if (i == currEnd) {
                jump++;
                currEnd = maxPos;
                if (currEnd >= n - 1) break;
            }

        }
        return jump;
    }
}

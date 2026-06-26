package Arrays;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        Arrays.sort(nums);
        int max = 0;
        int seq = 1;

        for(int i=1;i<n;i++){
            if(nums[i-1] == nums[i]){
                continue;
            }else if(nums[i-1]+1 == nums[i]){
                seq++;
            }else{
                max = Math.max(max,seq);
                seq=1;
            }
        }
        return Math.max(max,seq);

    }
}

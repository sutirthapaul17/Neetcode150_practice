package BackTracking;

import java.util.*;

public class CombinationSum2 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generatePermutation(0,nums,ans);
        return ans;
    }
    private void generatePermutation(int idx,int[] nums,List<List<Integer>> ans){
        int n = nums.length;

        if(idx == n-1){
            List<Integer> a = new ArrayList<>();
            for(int ele : nums) a.add(ele);
            ans.add(a);
            return;
        }

        for(int i = idx;i<n;i++){
            swap(i,idx,nums);
            generatePermutation(idx+1,nums,ans);
            swap(i,idx,nums);//backtrack

        }
    }
    private void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

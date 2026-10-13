package BackTracking;

import java.util.*;


public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(0,nums,target,ans,new ArrayList<>());
        return ans;
    }
    private void backTrack(int idx,int[] nums,int target,List<List<Integer>> ans,List<Integer> arr){
        if(target == 0){
            ans.add(new ArrayList<>(arr));
            return;
        }
        if(idx == nums.length || target<0){
            return;
        }

        arr.add(nums[idx]);
        backTrack(idx,nums,target - nums[idx],ans,arr);

        arr.remove(arr.size() - 1);
        backTrack(idx+1,nums,target,ans,arr);
    }
}

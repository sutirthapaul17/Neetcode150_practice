package BackTracking;

import java.util.*;

public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subsets(0,nums,ans,new ArrayList<>());
        return ans;
    }

    private void subsets(int idx,int[] nums,List<List<Integer>> ans,List<Integer> a){
        if(idx == nums.length){
            ans.add(new ArrayList<>(a));
            return;
        }

        a.add(nums[idx]);
        subsets(idx+1,nums,ans,a);
        a.removeLast();
        int next = idx + 1;
        while(next < nums.length && nums[next] == nums[idx]) next++; // Basically we won't check subsets for the values we have previously checked
        subsets(next,nums,ans,a);
    }


// for loop + Backtrack
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//
//        // Sort so duplicate elements are next to each other
//        Arrays.sort(nums);
//
//        subsets(0, nums, ans, new ArrayList<>());
//
//        return ans;
//    }
//
//    private void subsets(int idx, int[] nums,
//                         List<List<Integer>> ans,
//                         List<Integer> current) {
//
//        // Every state is a valid subset
//        ans.add(new ArrayList<>(current));
//
//        // Try every possible next element
//        for (int i = idx; i < nums.length; i++) {
//
//            // Skip duplicate choices at the same recursion level
//            if (i > idx && nums[i] == nums[i - 1]) {
//                continue;
//            }
//
//            // Choose
//            current.add(nums[i]);
//
//            // Recursively choose the next elements
//            subsets(i + 1, nums, ans, current);
//
//            // Backtrack
//            current.remove(current.size() - 1);
//        }
//    }
}

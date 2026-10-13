package BackTracking;

import java.util.*;


public class Subset {
    //using both the I and II backtracking approach , we can solve the question easily, But the II approach is recomended beacuse "It is The standard backtracking template used for Subsets, Permutations, and Combinations."

    //Backtracking(I)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        buildSubset(0,ans,new ArrayList<>(),nums);
        return ans;
    }

    private void buildSubset(int idx,List<List<Integer>> ans,List<Integer> a,int[] nums){
        if(idx == nums.length){
            ans.add(new ArrayList<>(a));
            return;
        }
        buildSubset(idx+1,ans,a,nums);
        a.add(nums[idx]);
        buildSubset(idx+1,ans,a,nums);
        a.removeLast();
    }

    //iterative
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        ans.add(new ArrayList<>());
//
//        for(int num : nums){
//            int size = ans.size();
//
//            for(int i=0;i<size;i++){
//                List<Integer> subsets = new ArrayList<>(ans.get(i));
//                subsets.add(num);
//                ans.add(subsets);
//            }
//        }
//        return ans;
//    }

    //for loop + recursion + Backtracking(II)
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        subsets(0, nums, ans, new ArrayList<>());
//        return ans;
//    }
//
//    private void subsets(int idx, int[] nums,
//                         List<List<Integer>> ans,
//                         List<Integer> a) {
//        ans.add(new ArrayList<>(a));
//
//        for (int i = idx; i < nums.length; i++) {
//            a.add(nums[i]);
//            subsets(i + 1, nums, ans, a);
//            a.remove(a.size() - 1);
//        }
//    }

}

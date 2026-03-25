package Arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
//    public static boolean hasDuplicate(int[] nums) {
//        int max = nums[0];
//        for(int ele:nums) max = Math.max(ele, max);
//        int n = max+1;
//        boolean[] ans= new boolean[n];
//        for(boolean ele:ans){
//            System.out.println(ele);
//        }
//        for(int i = 0;i<nums.length;i++){
//            if(ans[nums[i]]){
//                return true;
//            }else{
//                ans[nums[i]] = true;
//            }
//        }
//        return false;
//    }

    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        for(int ele: nums){
            if(ans.contains(ele)){
                return true;
            }
            ans.add(ele);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        boolean ans = hasDuplicate(nums);
        System.out.println("ans:"+ans);

    }
}

package Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
//    public int[] twoSum(int[] nums, int target) {
//        int i = 0, j=nums.length-1;
//        while(i<j){
//            if(nums[i]+nums[j] > target && nums[i]+nums[j]>0) j--;
//            else if(nums[i]+nums[j] > target && nums[i]+nums[j]<0) i++;
//            else if (nums[i]+nums[j] < target && nums[i]+nums[j] > 0) i++;
//            else if (nums[i]+nums[j] < target && nums[i]+nums[j] < 0) j--;
//            else break;
//        }
//        return new int[]{i,j};
//    }



//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer,Integer> map = new HashMap<>();
//        map.put(nums[0],0);
//        int idx1=0,idx2=0;
//        int i=1;
//        while(i < nums.length){
//            int diff = target - nums[i];
//            if(map.containsKey(diff)){
//                idx1= map.get(diff);
//                idx2 = i;
//                break;
//            }
//            map.put(nums[i],i);
//            i++;
//        }
//
//        return new int[]{idx1,idx2};
//    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0);
        int i=1;
        while(i < nums.length){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff),i};
            }
            map.put(nums[i],i);
            i++;
        }

        return new int[]{-1,-1};
    }
}

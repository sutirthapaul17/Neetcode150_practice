package BitManipulation;

import java.util.*;

public class SingleNumber {

        //using frequency count by hashmap , T.C -> O(n),A.s-> O(n)
//    public int singleNumber(int[] nums) {
//        HashMap<Integer, Integer> freq = new HashMap<>();
//        for (int ele : nums) {
//            freq.put(ele, freq.getOrDefault(ele, 0) + 1);
//        }
//
//        for (int ele : nums) {
//            if (freq.get(ele) == 1) {
//                return ele;
//            }
//        }
//
//        return -1;
//    }

    //XOR,T.C -> O(n),A.S->O(1)
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for(int i=1;i<nums.length;i++){
            ans = ans ^ nums[i];
        }
        return ans;
    }

}

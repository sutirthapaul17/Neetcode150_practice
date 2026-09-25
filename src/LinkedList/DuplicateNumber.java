package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class DuplicateNumber {
    //via freq array
//    public int findDuplicate(int[] arr) {
//        int n = arr.length;
//        int[] freq = new int[n];
//
//        for (int j : arr) {
//            freq[j]++;
//        }
//        for(int i=0;i<n;i++){
//            if(freq[i] > 1){
//                return i;
//            }
//        }
//        return 0;
//
//    }


    //via map
//    public int findDuplicate(int[] nums) {
//        int n = nums.length;
//        Map<Integer,Integer> map = new HashMap<>();
//
//        for (int ele : nums){
//            map.put(ele,map.getOrDefault(ele,0)+1);
//        }
//
//        for (int i=1;i<n;i++){
//            if (map.get(i) != null){
//                if(map.get(i) > 1){
//                    return i;
//                }
//            }
//        }
//        return 0;
//    }


    //via linked list
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        //cycle detection
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        int s2 = nums[0];
        while(slow != s2){
            slow=nums[slow];
            s2 = nums[s2];
        }
        return s2;
    }




}

package Arrays;

import java.util.*;

public class TopKFrequentElements {
//    public static int[] topKFrequent(int[] nums, int k) {
//        Map<Integer,Integer> map = new HashMap<>();
//
//        for(int ele:nums){
//            if(!map.containsKey(ele)){
//                map.put(ele,1);
//            }else{
//                map.put(ele,map.get(ele)+1);
//            }
//        }
//
//        map.forEach((key, value) -> {
//            System.out.println(key + " : " + value);
//        });
//
//        //Method-1 -> sorting based on values
//        int[] arr = map.entrySet()
//                .stream()
//                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
//                .mapToInt(Map.Entry::getKey)
//                .limit(k)
//                .toArray();
//
//        for(int ele:arr){
//            System.out.print(ele+" ");
//        }
//

//        return new int[]{2,3};
//    }


    public static int[] topKFrequent(int[] nums, int k) {

        // calculating frequency
        Map<Integer,Integer> map = new HashMap<>();
        for(int ele : nums){
            if(!(map.containsKey(ele))){
                map.put(ele,1);
            }else{
                map.put(ele,map.get(ele)+1);
            }
        }

        //Building the max Heap
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        maxHeap.addAll(map.entrySet());

        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = maxHeap.poll().getKey();
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,4,4,4,4,4,5,5,3,3};
        int[] ans = topKFrequent(nums,2);
    }
}

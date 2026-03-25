package Arrays;

import java.util.*;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int ele:nums){
            if(!map.containsKey(ele)){
                map.put(ele,1);
            }else{
                map.put(ele,map.get(ele)+1);
            }
        }

        map.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });

        //Method-1 -> sorting based on values
        int[] arr = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .mapToInt(Map.Entry::getKey)
                .limit(k)
                .toArray();

        //Method-2 -> sorting based on values(incomplete)
//        List<Integer> keys = new ArrayList<>(map.keySet());
//        keys.sort((k1, k2) -> map.get(k1).compareTo(map.get(k2)));
//        Integer[] arr = keys.toArray(new Integer[0]);


        for(int ele:arr){
            System.out.print(ele+" ");
        }

//        int[] ans = new int[k];
//        for(int i=0;i<arr.length;i++){
//            ans[i] = arr[i];
//        }

        return new int[]{2,3};
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,4,4,4,4,4,5,5,3,3};
        int[] ans = topKFrequent(nums,2);
    }
}

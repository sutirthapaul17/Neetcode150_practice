package SlidingWindow;

import java.util.*;

public class CountDistinctElementGFG {
    //Hashset
//    ArrayList<Integer> countDistinct(int[] arr, int k) {   // T.C = O(n*k) -> worst = O(n*n)
//        int i =0,j=k-1;
//        Set<Integer> set = new HashSet<>();
//        ArrayList<Integer> ans = new ArrayList<>();
//        while(j<arr.length){
//            int x = i;
//            while(x<=j){
//                set.add(arr[x]);
//                x++;
//            }
//            ans.add(set.size());
//            set.clear();
//            i++;
//            j++;
//        }
//        return ans;
//    }

    //Hashmap
    ArrayList<Integer> countDistinct1(int[] arr, int k) {
        int i =0,j=k-1;
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        while(j<arr.length){
            if(i==j){
                j++;
                i = j - k + 1;
                ans.add(map.size());
                map.put(arr[i-1], map.get(arr[i-1]) - 1);
                if(map.get(arr[i-1]) == 0){
                    map.remove(arr[i-1]);
                }
            }
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
            i++;

        }
        return ans;
    }


    ArrayList<Integer> countDistinct(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0;

        for (int j = 0; j < arr.length; j++) {

            // Add current element
            if (map.containsKey(arr[j])) {
                map.put(arr[j], map.get(arr[j]) + 1);
            } else {
                map.put(arr[j], 1);
            }

            // If window size is reached
            if (j - i + 1 == k) {
                ans.add(map.size());

                // Remove outgoing element
                map.put(arr[i], map.get(arr[i]) - 1);
                if (map.get(arr[i]) == 0) {
                    map.remove(arr[i]);
                }

                i++; // slide window
            }
        }

        return ans;
    }
}

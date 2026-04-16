package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
//    public List<List<Integer>> threeSum(int[] nums) {
//        int n = nums.length;
//        List<List<Integer>> ans = new ArrayList<>();
//
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//                for(int k=j+1;k<n;k++){
//                    if(nums[i] + nums[j] + nums[k] == 0){
//                        List<Integer> triplet = new ArrayList<>();
//                        triplet.add(nums[i]);
//                        triplet.add(nums[j]);
//                        triplet.add(nums[k]);
//                        Collections.sort(triplet);
//                        if(!ans.contains(triplet)) {
//                            ans.add(triplet);
//                        }
////                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                    }
//                }
//            }
//        }
//        return ans;
//    }


    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int k,j;
//        Arrays.sort(nums);

        System.out.println("entering loop");
        for(int i=0;i<n;i++){
            k = i+1;
            j = n-1;
            if(i>0 && nums[i] == nums[i-1]) continue;
            while(k<j){
                int sum = nums[i] + nums[j] + nums[k];
                System.out.println("Inside while loop");
                if(sum == 0){
//                    List<Integer> triplet = new ArrayList<>();
//                    triplet.add(nums[i]);
//                    triplet.add(nums[j]);
//                    triplet.add(nums[k]);
////                    Collections.sort(triplet);
//                    if(!ans.contains(triplet)) {
//                        ans.add(triplet);
//                    }
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    k++;
                    j--;
                    while(k<j && nums[k] == nums[k-1]) k++;
                    while(k<j && nums[j] == nums[j+1]) j--;
                }
                else if(sum < 0) k++;
                else j--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = threeSum(nums);
        for(List<Integer> ele:ans){
            System.out.println(ans);
        }
    }
}

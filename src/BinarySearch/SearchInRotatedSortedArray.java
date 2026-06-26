package BinarySearch;

public class SearchInRotatedSortedArray {

    //linear search
//    public int search(int[] nums, int target) {
//        int n = nums.length;
//        for(int i=0;i<n;i++){
//            if(nums[i]==target) return i;
//        }
//        return -1;
//    }



    //Binary Search
//    public int search(int[] nums, int target) {  // T.c -> O(n)
//        int l =0;
//        int n = nums.length;
//        int h = n -1;
//        int ans = 0;
//        while(nums[l] > nums[h]){
//            h--;
//        }
//        if(nums[l] <= target && nums[h] >= target){
//            //l=0 to h search
//            ans=binarySearch(nums,target,l,h);
//        }else{
//            l = h+1;
//            h = n-1;
//            ans = binarySearch(nums,target,l,h);
//
//        }
//        return ans;
//    }
//
//
//    public int binarySearch(int[] nums, int target,int left,int right){
//        int n = nums.length;
//        while(left<=right){
//            int mid = left + (right-left)/2;
//            if(nums[mid] == target){
//                return mid;
//            }else if( nums[mid] < target){
//                left = mid + 1;
//            }else{
//                right = mid - 1;
//            }
//        }
//        return -1;
//    }


    //T.C -> O(logn)
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // left half sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // right half sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}

package BinarySearch;

public class MinimumInRotatedSortedArray {
    //linear -> O(n)
//    public int findMin(int[] nums) {
//        int min = Integer.MAX_VALUE;
//        for(int ele : nums){
//            min = Math.min(ele,min);
//        }
//        return min;
//    }


    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // minimum is in right half
                left = mid + 1;
            } else {
                // minimum is in left half (including mid)
                right = mid;
            }
        }

        return nums[left];
    }
}

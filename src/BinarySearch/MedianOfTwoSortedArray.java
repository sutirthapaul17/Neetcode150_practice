package BinarySearch;

public class MedianOfTwoSortedArray {

    //Brute force
    //T.C -> O(m+n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m+n];
        int p1 = 0, p2 = 0, i = 0;
        // Merge both arrays
        while (p1 < m && p2 < n) {
            if (nums1[p1] <= nums2[p2]) {
                arr[i++] = nums1[p1++];
            } else {
                arr[i++] = nums2[p2++];
            }
        }
        while(p1<m){
            arr[i++] = nums1[p1++];
        }
        while(p2<n){
            arr[i++] = nums2[p2++];
        }
        int len = arr.length;
        if (len % 2 == 0) {
            return (arr[len / 2 - 1] + arr[len / 2]) / 2.0;
        } else {
            return arr[len / 2];
        }
    }



//    T.C -> O(m+n) , same time but with less space
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//        int m = nums1.length;
//        int n = nums2.length;
//
//        int total = m + n;
//
//        int i = 0, j = 0;
//        int count = 0;
//
//        int prev = 0, curr = 0;
//
//        while (count <= total / 2) {
//
//            prev = curr;
//
//            if (i < m && (j >= n || nums1[i] <= nums2[j])) {
//                curr = nums1[i];
//                i++;
//            } else {
//                curr = nums2[j];
//                j++;
//            }
//
//            count++;
//        }
//
//        if (total % 2 == 0) {
//            return (prev + curr) / 2.0;
//        }
//
//        return curr;
//    }


    //T.c -> O(log(m+n)), using binary search
//    class Solution {
//        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//            // Always binary search on the smaller array
//            if (nums1.length > nums2.length) {
//                return findMedianSortedArrays(nums2, nums1);
//            }
//
//            int m = nums1.length;
//            int n = nums2.length;
//
//            int low = 0;
//            int high = m;
//
//            while (low <= high) {
//
//                int partitionX = (low + high) / 2;
//                int partitionY = (m + n + 1) / 2 - partitionX;
//
//                int maxLeftX =
//                        (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
//
//                int minRightX =
//                        (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
//
//                int maxLeftY =
//                        (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
//
//                int minRightY =
//                        (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
//
//                if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
//
//                    if ((m + n) % 2 == 0) {
//                        return (Math.max(maxLeftX, maxLeftY)
//                                + Math.min(minRightX, minRightY)) / 2.0;
//                    }
//
//                    return Math.max(maxLeftX, maxLeftY);
//
//                } else if (maxLeftX > minRightY) {
//                    high = partitionX - 1;
//                } else {
//                    low = partitionX + 1;
//                }
//            }
//
//            throw new IllegalArgumentException("Input arrays are not sorted.");
//        }
//    }

}

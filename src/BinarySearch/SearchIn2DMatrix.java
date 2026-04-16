package BinarySearch;

public class SearchIn2DMatrix {

    //T.C = O(m+n)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i =0,j=n-1;
        while(i<m && j<n){
            if(matrix[i][j] < target){
                //go down
                i++;
            } else if (matrix[i][j] > target) {
                //go left
                j--;
            }else{
                //found
                return true;
            }
        }
        return false;
    }



//    T.C = O(log(m*n))  -> via binary search
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        int left = 0, right = m * n - 1;
//
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//
//            int row = mid / n;
//            int col = mid % n;
//
//            if (matrix[row][col] == target) {
//                return true;
//            } else if (matrix[row][col] < target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return false;
//    }
}

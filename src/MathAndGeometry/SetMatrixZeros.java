package MathAndGeometry;

public class SetMatrixZeros {
    ////using extra matrix -> A.s = O(m*n), it is restricted
//    public void setZeroes(int[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        int[][] helper= new int[m][n];
//
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                helper[i][j] = matrix[i][j];
//            }
//        }
//
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(helper[i][j] == 0){
//                    for(int k =0;k<m;k++) matrix[k][j] = 0;
//                    for(int k=0;k<n;k++) matrix[i][k] = 0;
//                }
//            }
//        }
//    }

    //Solution II
//    public void setZeroes(int[][] matrix) {
//        int m = matrix.length, n = matrix[0].length;
//        boolean[] row = new boolean[m];
//        boolean[] col = new boolean[n];
//
//        for (int i = 0; i < m; i++){
//            for (int j = 0; j < n; j++){
//                if (matrix[i][j] == 0) {
//                    row[i] = true;
//                    col[j] = true;
//                }
//            }
//        }
//
//        for (int i = 0; i < m; i++){
//            for (int j = 0; j < n; j++){
//                if (row[i] || col[j]) matrix[i][j] = 0;
//            }
//        }
//    }




    //Solution III(Optimized)
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        for(int j =0;j<n;j++){
            if(matrix[0][j] == 0) firstRowZero = true;
        }
        for(int i=0;i<m;i++){
            if(matrix[i][0] == 0 ) firstColZero = true;
        }

        // Step 2: use the first row and column as markers
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        // Step 3: make zero the inner cells based on the markers
        for(int i=1;i<m;i++){
            for(int j =1;j<n;j++){
                if( matrix[0][j] == 0 || matrix[i][0]==0) matrix[i][j] = 0;
            }
        }

        if(firstRowZero){
            for(int j=0;j<n;j++) matrix[0][j] =0;
        }
        if(firstColZero){
            for(int i=0;i<m;i++) matrix[i][0] = 0;
        }

    }
}

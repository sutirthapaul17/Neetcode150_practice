package MathAndGeometry;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n/2;i++){
            int k = n-i-1;
            for(int j=0;j<n;j++){
                swap(i,j,k,matrix);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void swap(int i,int j,int k,int[][] matrix){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][j];
        matrix[k][j] = temp;
    }
}

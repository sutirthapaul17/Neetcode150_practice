package MathAndGeometry;

import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int sr = 0;
        int sc=0;
        int er = m-1;
        int ec = n-1;

        while(ans.size() < m*n){
            for(int i = sc ; i<=ec;i++){
                ans.add(matrix[sr][i]);
            }
            sr++;
            if(ans.size() >= m*n) break;
            for(int i=sr;i<=er;i++){
                ans.add(matrix[i][ec]);
            }
            ec--;
            if(ans.size() >= m*n) break;
            for(int i = ec;i>=sc;i--){
                ans.add(matrix[er][i]);
            }
            er--;
            if(ans.size() >= m*n) break;
            for(int i = er;i>=sr;i--){
                ans.add(matrix[i][sc]);
            }
            sc++;

        }

        return ans;
    }
}

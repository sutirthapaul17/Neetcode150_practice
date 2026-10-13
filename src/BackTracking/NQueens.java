package BackTracking;

import java.util.*;


public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        placeQueens(0,board,ans);
        return ans;

    }

    private void placeQueens(int row,char[][] board,List<List<String>> ans){
        int n = board.length;
        if(row == n){
            List<String> sol = new ArrayList<>();
            for(int i=0;i<n;i++){
                sol.add(new String(board[i]));
            }
            ans.add(sol);
            return;
        }

        for(int j=0;j<n;j++){
            if(canBePlaced(row,j,board)){
                board[row][j] = 'Q';
                placeQueens(row+1,board,ans);
                board[row][j] = '.';
            }
        }
    }

    private boolean canBePlaced(int row,int col,char[][] board) {
        int n = board.length;
        for (int i = row - 1; i >= 0; i--) {//up
            if (board[i][col] == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {//left diagonal up
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; j++, i--) { //right diagonal up
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}

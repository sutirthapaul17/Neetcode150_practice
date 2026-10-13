package BackTracking;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] isVisited = new boolean[m][n];

        //checking for a valid starting cell
        for(int row=0;row<m;row++){
            for(int col = 0;col<n;col++){
                if(checkIfWordExistOrNot(0,row,col,board,word,isVisited)) return true;
            }
        }
        return false;
    }

    private boolean checkIfWordExistOrNot(int idx,int row,int col,char[][] board, String word,boolean[][] isVisited){
        int m = board.length;
        int n = board[0].length;
        //edge case
        if(row<0 || col<0 || row >= m || col >= n) return false;
        //if it is already visited cell or not
        if(isVisited[row][col]) return false;
        //word matching or not
        if(board[row][col] != word.charAt(idx)) return false;
        //Entire word found
        if(idx == word.length() - 1) return true;

        isVisited[row][col] = true;

        boolean checkPath=
                checkIfWordExistOrNot(idx + 1, row-1, col, board, word, isVisited) ||
                        checkIfWordExistOrNot(idx + 1, row, col-1, board, word, isVisited) ||
                        checkIfWordExistOrNot(idx + 1, row, col+1, board, word, isVisited) ||
                        checkIfWordExistOrNot(idx + 1, row+1, col, board, word, isVisited);

        isVisited[row][col] = false; //Backtrack

        return checkPath;
    }
}

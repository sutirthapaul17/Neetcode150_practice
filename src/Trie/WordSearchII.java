package Trie;

import java.util.*;

public class WordSearchII {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word = null;
    }

    private void insert(TrieNode root,String word){
        TrieNode curr = root;

        for(char ch : word.toCharArray()){
            int idx = ch - 'a';

            if(curr.child[idx] == null) curr.child[idx] = new TrieNode();

            curr = curr.child[idx];
        }
        curr.word = word;
    }


    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        List<String> ans = new ArrayList<>();

        for(String word:words){
            insert(root,word);
        }
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                searchWord( i, j,board, root, ans);
            }
        }
        return ans;
    }



    private void searchWord(
            int row,
            int col,
            char[][] board,
            TrieNode node,
            List<String> ans
    ){
        int m = board.length;
        int n = board[0].length;

        //out of bound
        if(row<0 || col<0 || row >= m || col>=n) return;

        char ch = board[row][col];

        if(ch == '#' || node.child[ch-'a'] == null) return;

        node = node.child[ch-'a'];

        if(node.word != null){
            ans.add(node.word);
            node.word = null;
        }

        board[row][col]='#';

        searchWord(row,col-1,board,node,ans);
        searchWord(row,col+1,board,node,ans);
        searchWord(row-1,col,board,node,ans);
        searchWord(row+1,col,board,node,ans);

        board[row][col]=ch;
    }
}

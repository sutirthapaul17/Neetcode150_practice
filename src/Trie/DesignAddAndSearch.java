package Trie;

public class DesignAddAndSearch {
    class TrieNode{
        TrieNode[] child;
        boolean eow;

        TrieNode(){
            child = new TrieNode[26];
            for(int i=0;i<26;i++){
                child[i] = null;
            }
            eow = false;
        }
    }

    class WordDictionary {
        TrieNode root;
        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                int idx = word.charAt(i) - 'a';
                if(curr.child[idx] == null) curr.child[idx] = new TrieNode();
                if(i==word.length()-1) curr.child[idx].eow = true;
                curr = curr.child[idx];
            }
        }

        public boolean search(String word) {
            return recursiveSearch(root,word,0);
        }

        private boolean recursiveSearch(TrieNode node,String word,int idx){

            if (idx == word.length()) {
                return node.eow;
            }

            char ch = word.charAt(idx);

            // Case 1: Dot can match any letter
            if (ch == '.') {
                for (TrieNode child : node.child) {
                    if (child != null) {
                        if (recursiveSearch(child, word, idx + 1)) {
                            return true;
                        }
                    }
                }
                return false;
            }

            // Case 2: Normal character
            int pos = ch - 'a';
            if(node.child[pos] == null)
                return false;

            return recursiveSearch(node.child[pos], word, idx + 1);
        }
    }

}

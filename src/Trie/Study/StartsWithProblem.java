package Trie.Study;

public class StartsWithProblem {

    static Basic.Node root1 = new Basic.Node();

    public static void insert(String word){
        Basic.Node curr = root1;
        for(int i=0;i<word.length(); i++){
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null){
                //add new node
                curr.children[idx] = new Basic.Node();
            }

            if(i == word.length()-1){
                curr.children[idx].eow = true;
            }

            curr = curr.children[idx];
        }
    }

    public static boolean search(String key){
        Basic.Node curr = root1;
        for(int i=0;i<key.length();i++) {

            int idx = key.charAt(i)-'a';
            Basic.Node node = curr.children[idx];

            if(node == null) return false;
            if(i== key.length() - 1 && !node.eow){
                return false;
            }
            curr= curr.children[idx];
        }
        return true;
    }

    private static boolean startsWith(String prefix){
        Basic.Node curr = root1;

        for(int i=0;i<prefix.length();i++){
            int idx = prefix.charAt(i) - 'a';

            if(curr.children[idx] == null){
                return false;
            }

            curr=curr.children[idx];
        }
        return true;
    }


    public static void main(String[] args) {
        String[] words = {
                "apple","app","mango","man","woman"
        };
        String prefix = "app";
        for(String word : words){
            insert(word);
        }

        System.out.println(startsWith(prefix));
    }
}

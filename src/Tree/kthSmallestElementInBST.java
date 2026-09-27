package Tree;

import java.util.ArrayList;
import java.util.List;

public class kthSmallestElementInBST {

    //Approah-I
//    public int kthSmallest(TreeNode root, int k) {
//        List<Integer> list = new ArrayList<>();
//        buildList(root,list);
//        return list.get(k-1);
//    }
//    private void buildList(TreeNode root , List<Integer> list){
//        if(root == null) return;
//        buildList(root.left,list);
//        list.add(root.val);
//        buildList(root.right,list);
//    }



    //Approach-2
    private int count =0;
    public int kthSmallest(TreeNode root, int k) {
        return inOrder(root,k);
    }
    private int inOrder(TreeNode root,int k){
        if(root == null) return -1;

        int left = inOrder(root.left,k);
        if (left != -1) return left;


        count++;
        if(count == k) return root.val;

        return inOrder(root.right, k);
    }

}

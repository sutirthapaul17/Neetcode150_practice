package Tree;

import java.util.*;

public class RightSideViewOfATree {

    //My solution
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(i == size - 1){
                    list.add(node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return list;
    }









//     Sir's solution
//    public ArrayList<Integer> rightSideView(TreeNode root) {
//        int n = levels(root);
//        int[] ans = new int[n];
//        preorder(root,0,ans);
//        ArrayList<Integer> ans2 = new ArrayList<>();
//        for(int ele : ans) ans2.add(ele);
//        return ans2;
//    }
//    private void preorder(TreeNode root, int lvl, int[] ans) {
//        if(root==null) return;
//        ans[lvl] = root.val;
//        preorder(root.left,lvl+1,ans);
//        preorder(root.right,lvl+1,ans);
//    }
//    private int levels(TreeNode root) {
//        if(root==null) return 0;
//        int leftLevels = levels(root.left), rightLevels = levels(root.right);
//        return 1 + Math.max(leftLevels,rightLevels);
//    }

}

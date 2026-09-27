package Tree;

import java.util.Stack;

public class BstValidityCheck {

//    public boolean isValidBST(TreeNode root) {
//        return checkIfBSTValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
//    }
//    private Boolean checkIfBSTValid(TreeNode root,long min,long max){
//        if(root == null) return true;
//
//        if(root.val <= min || root.val >= max){
//            return false;
//        }
//
//        return checkIfBSTValid(root.left,min,root.val) && checkIfBSTValid(root.right,root.val,max);
//    }



        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            long prev = Long.MIN_VALUE;

            while (curr != null || !stack.isEmpty()) {

                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }

                curr = stack.pop();

                if (curr.val <= prev) {
                    return false;
                }

                prev = curr.val;
                curr = curr.right;
            }

            return true;
        }
}

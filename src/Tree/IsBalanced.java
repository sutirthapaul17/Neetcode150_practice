package Tree;

public class IsBalanced {

    //Approach - I
//    boolean isBalanced = true;
//    public boolean isBalanced(TreeNode root) {
//        checkIfBalancedBinaryTree(root);
//        return isBalanced;
//    }
//    private int checkIfBalancedBinaryTree(TreeNode root){
//        if(root == null) return 0;
//        int left = checkIfBalancedBinaryTree(root.left);
//        int right = checkIfBalancedBinaryTree(root.right);
//        if(left - right >= 2 || right - left >= 2){
//            isBalanced = false;
//        }
//        return 1+Math.max(left,right);
//    }


    //Approach - II
//    public boolean isBalanced(TreeNode root) {
//        return checkIfBalancedBinaryTree(root) != -1;
//    }
//    private int checkIfBalancedBinaryTree(TreeNode root){
//        if(root == null) return 0;
//
//        int left = checkIfBalancedBinaryTree(root.left);
//        if(left == -1) return -1;
//
//        int right = checkIfBalancedBinaryTree(root.right);
//        if(right == -1) return -1;
//
//        if(Math.abs(left - right) > 1){
//            return -1;
//        }
//
//        return 1+Math.max(left,right);
//    }



//    //Approach - III
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    private int checkHeight(TreeNode root){
        if(root == null) return 0;

        int left = checkHeight(root.left);
        int right = checkHeight(root.right);

        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }

        return 1+Math.max(left,right);
    }
}

package Tree;

public class InvertBinaryTree {
    private void invert(TreeNode root){
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
}

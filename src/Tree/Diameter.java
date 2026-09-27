package Tree;

public class Diameter {
    //Approach 1
//    private int height(TreeNode root){
//        if(root == null) return 0;
//        return 1+Math.max(height(root.left),height(root.right));
//    }
//    public int diameterOfBinaryTree(TreeNode root) {
//        if(root == null) return 0;
//        int currentDiameter = height(root.left)+height(root.right);
//        int leftDiameter = diameterOfBinaryTree(root.left);
//        int rightDiameter = diameterOfBinaryTree(root.right);
//        return Math.max(currentDiameter,Math.max(leftDiameter,rightDiameter));
//    }

    //Approach 2
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeightAndDiameter(root);
        return diameter;

    }
    private int calculateHeightAndDiameter(TreeNode root){
        if (root == null) return 0;
        int left = calculateHeightAndDiameter(root.left);
        int right = calculateHeightAndDiameter(root.right);
        diameter = Math.max(diameter,left+right);
        return 1 + Math.max(left,right);
    }
}

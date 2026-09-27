package Tree;

public class CountGoodNodes {

    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private int countGoodNodes(TreeNode root, int maxSoFar) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val >= maxSoFar) {
            count = 1;
        }
        maxSoFar = Math.max(maxSoFar, root.val);
        count += countGoodNodes(root.left, maxSoFar);
        count += countGoodNodes(root.right, maxSoFar);
        return count;
    }
}

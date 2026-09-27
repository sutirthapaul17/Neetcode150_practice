package Tree;

public class ConstructBinaryTreeFromPreOrderAndInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    private TreeNode constructTree(int[] preorder, int[] inorder,int preStart,int preEnd,int inStart,int inEnd)   {
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIdx = inStart;
        while(inorder[rootIdx] != rootVal){
            rootIdx++;
        }

        int leftSize = rootIdx - inStart;
        root.left = constructTree(
                preorder,
                inorder,
                preStart+1,
                preStart+leftSize,
                inStart,
                rootIdx-1
        );

        root.right = constructTree(
                preorder,
                inorder,
                preStart+leftSize+1,
                preEnd,
                rootIdx+1,
                inEnd
        );
        return root;
    }
}

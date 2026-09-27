package Tree;

public class ConstructBinaryTreeFromInorderAndPostOrder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructTree(inorder,postorder,0,postorder.length-1,0,inorder.length-1);
    }
    private TreeNode constructTree(int[] inOrder, int[] postOrder,int postStart,int postEnd,int inStart,int inEnd){
        if(postStart > postEnd || inStart > inEnd) return null;

        int rootVal = postOrder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIdx = inStart;
        while(inOrder[rootIdx] != rootVal) rootIdx++;

        int leftSize = rootIdx - inStart;
        root.left= constructTree(
                inOrder,postOrder,postStart,postStart+leftSize-1,inStart,rootIdx-1
        );
        root.right= constructTree(
                inOrder,postOrder,postStart+leftSize,postEnd-1,rootIdx+1,inEnd
        );

        return root;
    }

}

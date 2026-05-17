package hot100.tree;

public class symmetricTree101 {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max =0;
        if(root == null)
            return max;
        getDepth(root);
        return max;
    }

    private int getDepth(TreeNode root) {
        if(root == null)
            return 0;
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        max = Math.max(l+r,max);
        return Math.max(l,r)+1;
    }
}

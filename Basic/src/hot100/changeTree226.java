package hot100;

public class changeTree226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        change(root);
        return root;
    }
    private void change(TreeNode pre){
        if(pre == null)
            return ;
        change(pre.left);
        change(pre.right);
        TreeNode temp = pre.left;
        pre.left = pre.right;
        pre.right = temp;
        return ;
    }
}

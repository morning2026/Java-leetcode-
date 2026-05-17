package hot100.tree;

public class changeTree226 {
    public TreeNode invertTree(TreeNode root) {
        change(root);// 里面已经判空了，外面不用
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

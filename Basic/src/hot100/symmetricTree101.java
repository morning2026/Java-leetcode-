package hot100;

public class symmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return compare(root.left,root.right);
    }
    private boolean compare(TreeNode left,TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val == right.val)
            return compare(left.left, right.right) && compare(left.right, right.left); // 左的左，右的右都要对称
        return false;// 值不相等就不对称
    }
}

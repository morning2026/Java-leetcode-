package hot100;
// 二叉搜索树不可以有相等值！！！
public class testTree98 {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return searchTree(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean searchTree(TreeNode cur,Long min,Long max)
    {
        if(cur == null)
            return true;
        if(cur.val >=max || cur.val<= min) //不可以等于
            return false;
        return searchTree(cur.left,min,(long)cur.val) && searchTree(cur.right,(long)cur.val,max);
    }
}

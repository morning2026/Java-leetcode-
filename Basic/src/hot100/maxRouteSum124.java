package hot100;

public class maxRouteSum124 {
    int max = Integer.MIN_VALUE;;
    public int maxPathSum(TreeNode root) {
        dfs(root); //有返回值的可以不截取
        return max;
    }
    private int dfs(TreeNode root) {
        if(root == null)
            return 0;
        int left = Math.max(dfs(root.left),0); //舍弃负数子树
        int right = Math.max(dfs(root.right),0);
        max = Math.max(max,left+right+ root.val);
        return Math.max(left,right)+root.val;
    }

}

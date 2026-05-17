package hot100.tree;

public class dtree543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        getdepth(root);
        return max;
    }
    private int getdepth(TreeNode pre){
        if(pre == null) return 0;
        int left = getdepth(pre.left);
        int right = getdepth(pre.right);
        max = Math.max(max,left+right);//左右最大深度，这时候不需要+1,这个算的是经过该结点的
        return Math.max(left,right)+1; //本结点的深度是左右取大+1
    }
}

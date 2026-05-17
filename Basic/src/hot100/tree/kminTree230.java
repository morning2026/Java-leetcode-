package hot100.tree;
// 中序遍历就是递增数组,注意算法
// 优化是记录子树的节点数/平衡二叉搜索树
public class kminTree230 {
    int count;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        countTree(root,k);
        return res;
    }
    private void countTree(TreeNode cur,int k){
        if(cur == null )
            return;
        countTree(cur.left,k);
        count++;
        if(count == k)
            res = cur.val;
        countTree(cur.right,k);
    }
}

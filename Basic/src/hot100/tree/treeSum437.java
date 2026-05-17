package hot100.tree;

import java.util.HashMap;
import java.util.Map;

//前缀和，计算到当前为止目标-本节点出现了几次
//long target是int但是val的数量级很快就会加到超过
public class treeSum437 {
    int target;
    Map<Long, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        map.put(0L,1); //初始化
        return dfs(root,0L);//起始前缀和为0
    }
    private int dfs(TreeNode root,long curSum){
        if(root == null)
            return 0;
        curSum += root.val;
        int res = map.getOrDefault(curSum - target,0); // 没拿到
        map.put(curSum,map.getOrDefault(curSum,0)+1); //不是res
        res+=dfs(root.left,curSum)+dfs(root.right,curSum); //左右子树
        map.put(curSum,map.get(curSum)-1);
        return res;
    }
}

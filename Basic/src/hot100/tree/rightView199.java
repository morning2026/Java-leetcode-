package hot100.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightView199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();;
            for(int i=0;i<size;i++){ //注意队列大小会变化，要固定
                TreeNode cur = queue.poll();
                if(i == size-1){//最后一个也要处理
                    res.add(cur.val);
                }
                if(cur.left != null)
                    queue.offer(cur.left);
                if(cur.right != null)
                    queue.offer(cur.right);
            }
        }
        return res;
    }
}

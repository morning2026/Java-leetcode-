package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class treeLevelOrder102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res =new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();//peek()是只看不拿；拿出同一层所有
                level.add(cur.val);// 操作完自己再操作孩子

                if(cur.left !=null){
                    queue.offer(cur.left);
                }
                if(cur.right !=null){
                    queue.offer(cur.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}

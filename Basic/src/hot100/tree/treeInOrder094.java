package hot100.tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class treeInOrder094 {
    List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        inorder(root);
        return result;
    }
    public void inorder(TreeNode root){
        if(root == null){ // 判空，不需要放入,注意根节点为空的情况
            return;
        }
        inorder(root.left);
        result.add(root.val); //注意顺序
        inorder(root.right);
    }
}

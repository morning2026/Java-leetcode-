package hot100;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val= val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       for(int i=0;i<inorder.length;i++)
           map.put(inorder[i],i);
       return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    private TreeNode build(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR){
        if(preL>preR)
            return null;
        int now = map.get(preorder[preL]);
        TreeNode root = new TreeNode(preorder[preL]);
        int len = now - inL;
        TreeNode left = build(preorder,preL+1,preL+len,inorder,inL,now-1);
        TreeNode right = build(preorder,preL+len+1,preR,inorder,now+1,inR);
        root.left = left;
        root.right = right;
        return root;
    }

}

package hot100;

import java.util.HashMap;
import java.util.Map;
//确定根，确定左子树，构建
public class buildTreeOrders105 {
    Map<Integer,Integer> map = new HashMap<>(); //键值对
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

    }
    private TreeNode build(int[] preorder, int preL, int preR, //直接返回根节点
                           int[] inorder, int inL, int inR){
        if(preL>preR)
            return null;
        TreeNode root = new TreeNode(preorder[preL]);
        int index = map.get(root.val);
        int len = index - inL;
        TreeNode left = build(preorder,preL+1,preL+len,inorder,inL,index -1); //上下限,注意是划出每个数组的地点
        TreeNode right = build(preorder,preL+len+1,preR,inorder,index+1,inR); // 根左右
        root.left = left;
        root.right = right;
        return root;
    }
}

package hot100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class treeMaxDepth104 {
    //不能直接在类里面创建自己的对象
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }//调用自己直接递归
    public TreeNode buildtree(Integer[] arr){
        Queue<TreeNode>queue = new LinkedList<TreeNode>();
        if(arr[0]==null) return new TreeNode(); // 空树
        TreeNode root = new TreeNode(arr[0]);
        int i=1;
        queue.offer(root);
        while(!queue.isEmpty() && i < arr.length){
            TreeNode cur = queue.poll();
            if( arr[i] != null){
                cur.left = new TreeNode(arr[i]);
                queue.offer(cur.left);
            }
            i++;
            if( i < arr.length && arr[i] != null){ //数组越界异常
                cur.right = new TreeNode(arr[i]);
                queue.offer(cur.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        treeMaxDepth104 t = new treeMaxDepth104();
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];//包装类可以有null
        for(int i=0;i<n;i++){
            String s = sc.next(); //用s接收null
            if(s.equals("null")){
                arr[i] = null;
            }
            else arr[i] = Integer.parseInt(s);
        }
        TreeNode root = t.buildtree(arr);
        System.out.println(t.maxDepth(root));
    }
}

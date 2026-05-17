package hot100.tree;

public class bulidTree108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        return bulid(nums,0,nums.length-1);//注意边界
    }
    private TreeNode bulid(int[] nums,int l,int r){
        if(l>r)
            return null;//空就好，没有
        int mid = (l+r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bulid(nums,l,mid-1); // 不能包含mid，因为已经建过了
        root.right = bulid(nums,mid+1,r);
        return root;
    }
}

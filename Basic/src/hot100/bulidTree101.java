package hot100;

public class bulidTree101 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        return bulid(nums,0,nums.length-1);
    }
    private TreeNode bulid(int[] nums,int l,int r){
        if(l>r)
            return null;
        int mid = (l+r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bulid(nums,l,mid-1); // 不能包含mid，因为已经建过了
        root.right = bulid(nums,mid+1,r);
        return root;
    }
}

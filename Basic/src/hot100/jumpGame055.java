package hot100;
// 看cover
public class jumpGame055 {
    public boolean canJump(int[] nums) {
        int cover = 0;
        for(int i=0;i<=cover;i++){
            if(cover>=nums.length-1)
                return true;
            cover = Math.max(cover,i+nums[i]);
        }
        return false;
    }
}

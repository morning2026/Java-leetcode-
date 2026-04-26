package hot100;

public class maxMutiply152 {
    public int maxProduct(int[] nums) {
        long imax = nums[0];
        long imin = nums[0];
        long max = nums[0];
        for(int i=1;i<nums.length;i++){
            long temp = imax;
            imax= Math.max(nums[i],Math.max(nums[i]*imax,nums[i]*imin));
            imin= Math.min(nums[i],Math.min(nums[i]*temp,nums[i]*imin)); // 复制过来要记得改
            max = Math.max(imax,max);
        }
        return (int)max; // 看return值
    }
}

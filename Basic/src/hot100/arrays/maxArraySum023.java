package hot100.arrays;

//一个当前最大和，一个全局最大和
public class maxArraySum023 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0],curSum = nums[0];
        for(int i=1;i<nums.length;i++){
            curSum = Math.max(curSum+nums[i],nums[i]);
            ans = Math.max(curSum,ans);
        }
        return ans;
    }
}

package hot100.dp;

public class cutNums416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0)
            return false;
        int target = sum/2;
        boolean[] dp = new boolean[target+1]; // 0->+1
        dp[0]=true;
        for(int num:nums){
            for(int j = target;j>=num;j--) // 不要越界
                dp[j] = dp[j] || dp[j-num];
        }
        return dp[target];
    }
}

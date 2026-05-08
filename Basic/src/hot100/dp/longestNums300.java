package hot100.dp;

import java.util.Arrays;
// 贪心+二分更快，但是动态规划简单
public class longestNums300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length]; // 数组的长度代表什么
        int result =1; // 至少有1长
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++)
                if(nums[j]<nums[i])
                    dp[i] = Math.max(dp[i],dp[j]+1); // 要操作什么
            result = Math.max(dp[i],result);
        }
        return result;
    }
}

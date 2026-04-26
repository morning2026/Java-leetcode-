package hot100;

import java.util.Arrays;

public class money322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<coins.length;i++)
            for(int j= coins[i];j<=amount;j++){ // 最后一位要算
                if(dp[j-coins[i]]!=Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j-coins[i]]+1,dp[j]);
                }
            }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount]; //异常判断
    }
}

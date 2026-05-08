package hot100.dp;

import java.util.Arrays;

// 背包问题 平方数是物品，数是背包
public class squares279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1]; // 数组越界
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i*i<=n;i++){ // 本身就是完全平方数
            for(int j=i*i;j<=n;j++){ // 从第一个完全平方开始装
                dp[j]=Math.min(dp[j],dp[j-i*i]+1);
            }
        }
        return dp[n];
    }
}

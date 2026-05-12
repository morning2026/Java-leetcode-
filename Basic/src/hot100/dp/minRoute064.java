package hot100.dp;
// 注意方向,注意不要溢出
public class minRoute064 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int i=1;i<n;i++){
            dp[i]= grid[0][i]+dp[i-1];//注意怎么得到的
        }

        for(int i=1;i<m;i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j<n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[n-1];
    }
}

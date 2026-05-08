package hot100.dp;

public class editDistance072 {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++)
            dp[i][0]=i;
        for(int j=0;j<=l2;j++)
            dp[0][j]=j;
        for(int i=1;i<=l1;i++){
            char char1 = word1.charAt(i-1);
            for(int j=1;j<=l2;j++){
                char char2 = word2.charAt(j-1);
                if(char1 == char2){
                    dp[i][j]= dp[i-1][j-1];
                }else { // 不操作只记录
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
            }
        }
        return dp[l1][l2];
    }
}

package hot100;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[] dp = new int[l2+1];
        dp[0]=0;
        int pre;
        for(int i=1;i<=l1;i++){
            pre = dp[0];
            for(int j=1;j<=l2;j++){
                int temp = dp[j];
                if(text1.charAt(i+1)==text2.charAt(j+1)) {
                    dp[j] = pre + 1;
                }
                else{
                    dp[j]=Math.max(dp[j],dp[j-1]);
                }
                pre = temp;
            }
        }
        return dp[l2+1];
    }
}

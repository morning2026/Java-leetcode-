package hot100;

public class maxPublic1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[] dp = new int[l2+1];
        for(int i=1;i<=l1;i++){//比到最后一位
            int pre = dp[0];// 每一次都要记录
            char char1 = text1.charAt(i-1);
            for(int j=1;j<=l2;j++){
                char char2 = text2.charAt(j-1);
                int cur = dp[j];
                if(char1 == char2){
                    dp[j]= pre+1; // 左上角的值+1
                }else {
                    dp[j]= Math.max(dp[j],dp[j-1]);//自己和左边
                }
                pre = cur;
            }
        }
        return dp[l2];
    }
}

package hot100;

public class maxBrackets032 {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int maxLen = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = i>=2 ?dp[i-2]+2:2; // 保证不越界
                }
                else {
                    int match = i-dp[i-1]-1;
                    if(match >=0 && s.charAt(match)=='(') { // 防止越界
                        dp[i] = dp[i - 1] + 2; // 前面的成对的，因为必然隔断
                        if(match-1>=0)
                            dp[i]+=dp[match-1]; //括号钱
                    }
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}

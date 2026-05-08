package hot100.dp;

public class maxString005 {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0,begin=0,end =0;
        boolean[][] dp = new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++) { //j在i后面，不要访问错
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1)
                        dp[i][j] = true;
                    else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
                if(dp[i][j] && j-i+1>maxLen){ //必须是回文
                    maxLen = j-i+1;
                    begin = i;
                    end = j;
                }
            }
        }
        return s.substring(begin,end+1); // 左闭右开
    }
}

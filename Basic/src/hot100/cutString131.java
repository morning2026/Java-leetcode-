package hot100;

import java.util.ArrayList;
import java.util.List;

public class cutString131 {
    List<List<String>> res = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    boolean[][] dp;
    int len;
    public List<List<String>> partition(String s) {
        len = s.length();
        dp = new boolean[len][len]; //正常大小就够了
        isCnt(s);
        cut(s,0);
        return res;
    }
    private void isCnt(String s){
        for(int i=0;i<len;i++)
            dp[i][i]=true;
        for(int i=1;i<len;i++) // 注意数组修改
            for(int j=i-1;j>=0;j--){
                if(s.charAt(j)==s.charAt(i)){
                    if(j == i-1 || dp[j+1][i-1])
                        dp[j][i]=true; //小的在前
                }
            }
    }
    private void cut(String s,int begin){
        if(begin >= s.length()){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i=begin;i<s.length();i++){
            if(dp[begin][i]){
                ans.add(s.substring(begin,i+1));
                cut(s,i+1);
                ans.removeLast();
            }
        }
    }
}

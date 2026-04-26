package hot100;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

// 先背包再物品
public class wordSplit139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> word = new HashSet<>();
        for(String words : wordDict){
            word.add(words);
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            if(!dp[i]){
                for(int j=0;j<i;j++)
                    if(word.contains(s.substring(j,i)) && dp[j]){ // 注意左右
                        dp[i] = true;
                        break;
                    }
            }
        }
        return dp[s.length()];
    }
}

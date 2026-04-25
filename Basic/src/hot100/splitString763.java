package hot100;

import java.util.ArrayList;
import java.util.List;

// 哈希+贪心，存最后一个字母出现的位置
public class splitString763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] charLast = new int[26];
        for(int i=0;i<s.length();i++){
            charLast[s.charAt(i)-'a']=i;
        }
        int begin=0,max=0;
        for(int i=0;i<s.length();i++){
            max = Math.max(max,charLast[s.charAt(i)-'a']); //当前能走到最远的地方，实则是max
            if(i==max){
                ans.add(max-begin+1); // 看题
                begin = max+1;
            }
        }
        return ans;
    }

}

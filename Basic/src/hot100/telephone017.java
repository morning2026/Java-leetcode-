package hot100;

import java.util.ArrayList;
import java.util.List;

public class telephone017 {
    StringBuilder path = new StringBuilder();
    List<String> res = new ArrayList<>();
    String[] phone = new String[]{"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
          if(digits == null || digits.isEmpty()){
              return res;
          }
          cnt(digits,0);
          return res;
    }
    private void cnt(String digits,int begin){
        if(begin == digits.length()){//不会超过
            res.add(path.toString());
            return;
        }
        String cur = phone[digits.charAt(begin)-'1']; // 字符串运算
        for(int i=0;i<cur.length();i++)
        {
            path.append(cur.charAt(i));
            cnt(digits,begin+1);
            path.deleteCharAt(path.length()-1); // 字符串没有弹出最后一位
        }
        return;
    }
}

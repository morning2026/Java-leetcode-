package hot100;

import java.util.Deque;
import java.util.LinkedList;

public class stringCode394 {
    public String decodeString(String s) {
        StringBuilder curStr = new StringBuilder();
        Deque<Integer> numStack = new LinkedList<>();
        Deque<String> strStack = new LinkedList<>();
        int num=0;
        for(char c : s.toCharArray()){
            if('0'<=c && c<='9'){
                num = num*10 + (int)(c-'0');
            } else if(c == '['){ // 一个字符不要多个判断
                numStack.push(num);
                strStack.push(curStr.toString()); // 原字符串入栈
                num = 0;
                curStr = new StringBuilder();
            }else if('a'<=c && c<='z'){
                curStr.append(c);
            }else if(c == ']'){
                int cnt = numStack.pop(); // 不一定是原来的num
                StringBuilder temp = new StringBuilder(strStack.pop());
                for(int i=0;i<cnt;i++){
                    temp.append(curStr);
                }
                num = 0;
                curStr = temp;
            }
        }
        return curStr.toString();
    }
}

package hot100;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class rightBrackets020 {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Deque<Character> stack = new LinkedList<>();
        for(char c:s.toCharArray()){
            if(map.containsKey(c)){
                if(stack.isEmpty() || stack.peek()!= map.get(c)){
                    return false;
                }else
                    stack.pop(); // 弹出，注意这是栈模式
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty(); // 必须为空
    }
}

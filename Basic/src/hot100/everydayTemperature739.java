package hot100;

import java.util.Deque;
import java.util.LinkedList;
// 存索引
public class everydayTemperature739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[n];// 不要忘记初始化
        for(int i=0;i<n;i++){
            while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }
        return ans;
    }
}

package hot100;

import java.util.Deque;
import java.util.LinkedList;

public class maxTriangle084 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new LinkedList<>();
        int maxx = 0;
        for(int i=0;i<=n;i++){
            int curH = i==n?0:heights[i];
            while (!stack.isEmpty() && curH < heights[stack.peek()]){//存下标非高度
                int hIdx = stack.pop();
                int height = heights[hIdx];
                int left = stack.isEmpty()?-1:stack.peek(); // 讨论空栈
                maxx = Math.max(height*(i-left-1),maxx);
            }
            stack.push(i);
        }
        return maxx;
    }
}

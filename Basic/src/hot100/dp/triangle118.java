package hot100.dp;

import java.util.ArrayList;
import java.util.List;

public class triangle118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<=i;j++) // 第i行有i个元素
                row.add(1);
            if(i>=2) { // 初值
                List<Integer> pre = ans.get(i - 1); // 注意这个不是数组，怎样处理
                for (int j = 1; j < i; j++)
                    row.set(j, pre.get(j) + pre.get(j - 1));
            }
            ans.add(row);
        }
        return ans;
    }
}

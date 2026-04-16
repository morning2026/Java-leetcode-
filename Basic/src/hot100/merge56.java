package hot100;
import java.util.*;
public class merge56 {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return new int[0][];
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]); // 注意格式
        List<int[]> res = new ArrayList();
        res.add(intervals[0]);
        int[] last = new int[2];
        for(int i=1;i< intervals.length;i++){
            last = res.get(res.size()-1);
            if(intervals[i][0] <= last[1]) // 等于也可以
                last[1] = Math.max(intervals[i][1],last[1]); // 考虑到可能出现前区更大,注意从0开始
            else
                res.add(intervals[i]);
        }
        return res.toArray(new int[res.size()][]); // 格式
    }
    public static void main(String args[]){
        merge56 m = new merge56();
        int[][] s = m.merge(new int[][]{{1,4},{4,5}});
        for(int i=0;i<s.length;i++)
            System.out.print(Arrays.toString(s[i])); // 输出格式
    }
}

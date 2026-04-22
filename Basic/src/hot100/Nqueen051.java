package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nqueen051 {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[] row = new int[n];
        boolean[] col = new boolean[n];
        boolean[] dia1 = new boolean [2*n];
        boolean[] dia2 = new boolean [2*n];
        setQueen(n,0,row,col,dia1,dia2);
        return res;
    }

    private void setQueen(int n,int now,int[] row, boolean[] col, boolean[] dia1, boolean[] dia2){ //1和2写反了，但是不影响
        if(now == n){
            res.add(makeQueen(row,n));
            return;//后面不遍历，会溢出
        }
        for(int i=0;i<n;i++){
            if(!col[i]&&!dia1[i-now+n]&&!dia2[i+now]){
                col[i] = true;
                dia1[i-now+n] = true;
                dia2[i+now] = true;
                row[now] = i;
                setQueen(n,now+1,row,col,dia1,dia2);
                col[i] = false;
                dia1[i-now+n] = false;
                dia2[i+now] = false;
            }
        }
        return;
    }

    private List<String> makeQueen(int[] row,int n) {
        List<String> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            char[] c = new char[n];
            Arrays.fill(c,'.');
            c[row[i]]='Q';
            ans.add(new String(c)); //c.toString() 输出的是数组地址（如 [C@12345]），不是字符串！
        }
        return ans;
    }
}

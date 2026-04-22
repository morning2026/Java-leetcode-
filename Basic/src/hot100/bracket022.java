package hot100;

import java.util.ArrayList;
import java.util.List;

public class bracket022 {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        dfs(0,0,n);
        return res;
    }
    private void dfs(int left,int right,int n){
        if(left == n && right == n){
            res.add(path.toString());
            return;
        }
        if(left + right > 2*n)
            return;
        if(left <= n){
            path.append('(');
            dfs(left+1,right,n);
            path.deleteCharAt(path.length()-1);
        }
        if(right < left){
            path.append(')');
            dfs(left,right+1,n);
            path.deleteCharAt(path.length()-1);
        }

    }
}

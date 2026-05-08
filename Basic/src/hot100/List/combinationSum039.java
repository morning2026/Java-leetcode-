package hot100.List;

import java.util.ArrayList;
import java.util.List;
// 注意传入的参数是啥
public class combinationSum039 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) // 空值安全
            return res;
        cnt(candidates,target,0,0);
        return res;
    }
    private void cnt(int[] candidates,int target, int begin, int curtarget){
        if(curtarget == target){
            res.add(new ArrayList<>(path)); // 必须新建不然报错
            return;
        }
        if(curtarget > target){ //剪枝
            return;
        }
        for(int i=begin;i<candidates.length;i++){ // 可以重复使用
            int sum = curtarget + candidates[i];
            path.add(candidates[i]);
            cnt(candidates,target,i,sum);
            path.removeLast();
        }
    }
}

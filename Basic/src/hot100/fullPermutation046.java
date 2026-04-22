package hot100;

import java.util.ArrayList;
import java.util.List;

public class fullPermutation046 {
    List<List<Integer>> res =new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        cnt(nums,0);
        return res;
    }
    private void cnt(int[] nums,int begin){
        if(begin == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                used[i]=true;
                path.add(nums[i]);
                cnt(nums,begin+1); // 记录已经放进去的
                path.removeLast();
                used[i]=false;
            }
        }
    }
}

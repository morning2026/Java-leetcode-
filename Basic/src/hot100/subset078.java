package hot100;

import java.util.ArrayList;
import java.util.List;

public class subset078 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length ==0){
            return res;
        }
        make(nums,0);// 直接往下，后面的也会够到的，没必要提前加空集
        return res;
    }
    private void make(int[] nums,int begin){
        res.add(new ArrayList<>(path)); // 不用剪枝因为不会溢出
        for(int i=begin;i<nums.length;i++){
            path.add(nums[i]);
            make(nums,i+1); // 不能重复
            path.removeLast();
        }
    }
}

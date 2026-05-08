package hot100.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumSum015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        int left, right;
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] > 0) break;
            if (i>0 && nums[i] == nums[i - 1]) continue;//i为0的时候会溢出，问i+1会漏解（左指针）
            left = i+1;
            right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right])); // 注意语法
                    //break; 漏解
                    while (left < right && nums[left] == nums[left + 1]) left++;//找到后注意去重
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    //找到一个三元组之后注意去重
                    left++;
                    right--;//指针要动
                }
                else if (sum < 0) {
                    //while (left < right && nums[left] == nums[left + 1]) left++; 没必要，反而多套一层
                    left++;
                }
                else {
                    //while (left < right && nums[right] == nums[right - 1]) right--;
                    right--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        ThreeNumSum015 threeNumSum015 = new ThreeNumSum015();
        List<List<Integer>> res = threeNumSum015.threeSum(new int[]{1,2,0,1,0,0,0,0});
        System.out.println(res);
    }
}

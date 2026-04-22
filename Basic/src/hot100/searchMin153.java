package hot100;

public class searchMin153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1; // 别越界
        while(left < right){ // 最小值必须左闭右开
            int mid = left + ((right - left)>>1);
            if(nums[mid] > nums[right]){ // 反常
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return nums[left]; // 最终结果，不是索引
    }
}

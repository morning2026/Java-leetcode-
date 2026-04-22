package hot100;

public class searchPosition35 {
    public int searchInsert(int[] nums, int target) {
        int left =0;
        int right = nums.length;
        while(left < right){
            int mid = left+((right-left)>>1);
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>target)
                right = mid;
            else
                left = mid+1;
        }
        return left;
    }
}

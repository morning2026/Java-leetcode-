package hot100;
// 两次二分更好,左闭右闭好写
public class findNum034 {
   /* public int[] searchRange(int[] nums, int target) {
        int a = search(nums,target);
        if(a == -1)
            return new int[]{-1,-1};
        return findlr(nums,a,target);
    }
    private int search(int[] nums,int target){
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
        return -1;
    }
    private int[] findlr(int[] nums,int now,int target){ // 代表什么
        int left = now, right = now;
        while(left>=0 && nums[left] == target ){ // 防越界写前面
            left--;
        }
        left++; // 退出时什么情况
        while(right< nums.length &&nums[right]== target ){
            right++;
        }
        right--;
        return new int[]{left,right};
    }*/
   public int[] searchRange(int[] nums, int target) {
       int left = findL(nums,target);
       int right = findR(nums,target);
       return new int[]{left,right};
   }
   private int findL(int[] nums, int target){
       int left =0;
       int right = nums.length-1;
       while(left <= right){ //并不是找唯一一个
           int mid = left+((right-left)>>1);
           if(nums[mid]>=target)
               right = mid-1;
           else
               left = mid+1;
       }
       if(left>=nums.length || nums[left]!=target)
           return -1;
       return left;
   }
   private int findR(int[] nums, int target){
       int left =0;
       int right = nums.length-1;
       while(left <= right){
           int mid = left+((right-left)>>1);
           if(nums[mid]>target) //左右边界要纠察得很细
               right = mid-1;
           else
               left = mid+1;
       }
       if(right<0 || nums[right]!=target)
           return -1;
       return right;
    }
}

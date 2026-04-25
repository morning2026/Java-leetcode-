package hot100;
// 类似双指针
public class sortColor075 {
    public void sortColors(int[] nums) {
        int left =0,right =nums.length-1;
        int cur=0;
        while(cur<=right){
            if(nums[cur]==0){
                swap(nums,left,cur);
                left++;
                cur++;//已经处理好了，必然合法
            }
            else if(nums[cur]==2){
                swap(nums,right,cur);
                right--;//内收
            }else {
                cur++; // 等于1正常
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

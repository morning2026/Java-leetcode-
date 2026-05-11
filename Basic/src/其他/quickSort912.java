package 其他;
import java.util.Random;
public class quickSort912 {
    Random rand = new Random();
    public int[] sortArray(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }
    private void sort(int[] nums,int l,int r){
        if(l>=r)
            return;
        int cur = l+ rand.nextInt(r-l+1); //生成0-n的随机数，左闭右开
        swap(nums,cur,r);
        int lnow = l;
        for(int i=l;i<r;i++){
            if(nums[i]<nums[r]){
                swap(nums,lnow,i);
                lnow++;
            }
        }
        swap(nums,lnow,r);
        sort(nums,l,lnow-1);
        sort(nums,lnow+1,r);
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

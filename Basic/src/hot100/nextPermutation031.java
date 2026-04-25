package hot100;

public class nextPermutation031 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i =n-2;
        while(i>=0 && nums[i+1]<=nums[i]){
            i--;
        }
        if(i>=0){ //这样才可以交换
            int j=n-1;
            while(j>=0 && nums[j]<=nums[i]) //找第一个大的
                j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1,n-1);//i不动
    }
    private void reverse(int[] nums,int l,int r){
        while(l<r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }
    private void swap(int[] nums,int i,int j){ // 不要异或swap
        int temp = nums[j]; //不要写错
        nums[j] =nums[i];
        nums[i] =temp;
    }
}

package hot100;

public class removeZero283 {
    public void moveZeroes(int[] nums) {
        int now = 0,temp;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                temp = nums[i];
                nums[i] = nums[now++];
                nums[now-1] = temp;
                /*// 位运算解法（错误，自己换自己会炸掉）
                nums[now] = nums[now] ^ nums[i];
                nums[i] = nums[now] ^ nums[i];
                nums[now] = nums[now] ^ nums[i];
                now++;*/
            }
        }
    }
}

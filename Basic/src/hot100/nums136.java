package hot100;

public class nums136 {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int s1=0;// 0^x =x
        for(int i=0;i<n;i++)
            s1^=nums[i];
        return s1;
    }
}

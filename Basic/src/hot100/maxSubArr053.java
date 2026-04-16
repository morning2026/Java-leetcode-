package hot100;
//dp标准答案，还有个答案是线段树，先不写学到了再写
public class maxSubArr053 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) //先null再length防止空指针，记住==和=的区别
            return 0;
        int len = nums.length,maxx = nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        for(int i = 1;i < len; i ++){
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]); //必须调max
        }
        for(int i = 1;i < len; i ++){
            maxx = dp[i]>maxx ? dp[i] : maxx;
        }
        return maxx;
    }
    public static void main(String args[]){
        maxSubArr053 m = new maxSubArr053();
        System.out.println(m.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}

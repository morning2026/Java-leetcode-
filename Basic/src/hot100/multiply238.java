package hot100;

public class multiply238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = nums[i - 1] * res[i-1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
    public static void main(String args[]){
        multiply238 m =new multiply238();
        int[] ans = m.productExceptSelf(new int []{1,2,3,4});
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]);
        }
    }
}
package hot100.twoPointer;

public class rain042 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0,lm = 0,rm = 0;
        while (left < right) {
            lm = Math.max(lm, height[left]);
            rm = Math.max(rm, height[right]);
            if (lm < rm) {
                res += lm - height[left];
                left++;
            } else {
                res += rm - height[right];
                right--;
            }
        }
        return res;
    }
}

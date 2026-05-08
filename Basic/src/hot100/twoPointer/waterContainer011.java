package hot100.twoPointer;
import java.util.Scanner;
public class waterContainer011 {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) { // [1,1]也可以算作容器
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        waterContainer011 w = new waterContainer011();
        System.out.println(w.maxArea(height));
    }
}


package hot100;

import java.util.HashSet;

public class MaxNums0128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        //System.out.println(set);
        int cnt,now;
        int max = 0;
        for ( int num : set) {
            if (!set.contains(num - 1)) {//找到起点
                cnt = 1;
                now = num;
                while(set.contains(now + 1)) {//一直找到这一串的最后一个数
                    cnt++;
                    now++;
                }
                if (cnt > max) {//更新最大长度
                    max = cnt;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        System.out.println(new MaxNums0128().longestConsecutive(nums));
    }
}

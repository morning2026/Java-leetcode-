package hot100;

import java.util.Arrays;
import java.util.HashMap;
//最开始的思路是用HashMap存放，先排序，排序完之后挨个比对，然后再加上里面原有的值，让++
//法一：暴力枚举o(n^2)
//法二：前缀和，k = presum[end+1]-presum[start],map记录前缀和和前缀和出现的次数。注意：连续！
public class sumK560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map =new HashMap<>();
        int count=0,preSum=0,target;
        map.put(0,1);
        for(int num:nums){
            preSum+=num;
            target = preSum-k;
            count+=map.getOrDefault(target,0);
            map.put(preSum,map.getOrDefault(preSum,0)+1);//记得加一
        }
        return count;
    }
    public static void main(String args[]){
        sumK560 sumK560 = new sumK560();
        System.out.println(sumK560.subarraySum(new int[]{1,1,1},2));
    }
}

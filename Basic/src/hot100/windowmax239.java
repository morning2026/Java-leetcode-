package hot100;

import java.util.Deque;
import java.util.LinkedList;

//只想到双重循环暴力算
public class windowmax239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k<=0||nums.length==0||nums ==null){//注意怎么判断数组为空
            return new int[0];
        }
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[n-k+1];
        for(int i = 0;i < n;i ++){
            while(!deque.isEmpty() && deque.peekFirst() < i-k+1){//注意队列基本操作
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);//记得放进去
            if(i>=k-1) res[i-k+1] = nums[deque.peekFirst()];//注意存的是下标
        }
        return res;
    }
}

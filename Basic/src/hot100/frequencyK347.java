package hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class frequencyK347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            int cnt = map.getOrDefault(nums[i],0);
            map.put(nums[i],cnt+1);
        }
        // 名字不要标反
        // 我们要的是entry
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());//小根堆格式
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){// 要写泛型
            minHeap.offer(entry);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int[] ans = new int[k];// 只会有k
        for(int i =0;i<k;i++){
            ans[i] = minHeap.poll().getKey(); // 答案要什么
        }
        return ans;
    }
}

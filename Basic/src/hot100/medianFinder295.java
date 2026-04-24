package hot100;

import java.util.PriorityQueue;
// 两个堆，一大一小
public class medianFinder295 {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public medianFinder295() {
        maxHeap = new PriorityQueue<>((a,b)->(b-a));
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || num<=maxHeap.peek()){// 需不需要弹出，等于顶也行
            maxHeap.offer(num);
        }
        else {
            minHeap.offer(num);
        }
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }
        if(minHeap.size()>maxHeap.size()){ // 两个差别大才弹
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size()>minHeap.size())
            return maxHeap.peek();
        return (maxHeap.peek()+minHeap.peek())/2.0;
    }
}

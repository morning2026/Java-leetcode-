package hot100;

import java.util.PriorityQueue;

public class maxK215 {
    /*public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();// 注意名字
        for(int num: nums){
            minHeap.offer(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }*/
    int[] minHeap;
    int size;
    public int findKthLargest(int[] nums, int k) {
        minHeap = new int[k];
        size = 0;
        for(int num: nums){
            if(size < k){
                offerHeap(num);
            }
            // 满了就比较，比堆顶大才替换
            else if(num > minHeap[0]){
                poll();
                offerHeap(num);
            }
        }
        return peek();
    }
    private void offerHeap(int val){
        minHeap[size++] = val;// 这样0才有得存，从最后一个开始上浮
        Up(size-1); //size现在空的
        return;
    }
    private int poll(){
        int top = minHeap[0];
        minHeap[0]= minHeap[size-1]; //不要越界
        size--;
        Down(0);
        return top;
    }
    private int peek(){
        return minHeap[0];
    }
    private void Up(int idx){ //上浮，变小
        while(idx>0){
            int parent = (idx-1)/2;
            if(minHeap[idx]>=minHeap[parent]) // 没反不用换
                break; //浮到最上面
            swap(idx,parent);
            idx = parent; //交换父子然后往上
        }
    }
    private void Down(int idx){ //下沉
        while (true){ // 最后一次还是要换
            int left = idx*2+1;
            int right = idx*2+2;
            int min = idx;
            if(left<size && minHeap[left]<minHeap[min]){
                min = left;
            }
            if (right<size && minHeap[right]<minHeap[min]) {//要找出最小的，不能用else，比最小的，是min
                min = right;
            }
            if(min == idx)
                break;
            swap(min,idx); // 只有这里换
            idx = min;
        }
    }
    private void swap(int i,int j){//堆里会自己换自己
        int temp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = temp;
    }
}

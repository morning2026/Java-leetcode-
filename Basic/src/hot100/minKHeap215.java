package hot100;

public class minKHeap215 {
    int[] minheap;
    int size=0;
    public int findKthLargest(int[] nums, int k) {
        minheap = new int[k];// 初始化
        for(int i=0;i< nums.length;i++){
            if(size<k){
                offerHeap(nums[i]);
            }else{
                if(nums[i]>minheap[0]){//Kmax
                    poll();
                    offerHeap(nums[i]);
                }
            }
        }
        return peek();
    }
    private int peek(){
        return minheap[0];
    }
    private void poll(){
        minheap[0]=minheap[size-1];
        size--;
        Down(0);//防止溢出
    }
    private void Down(int idx){
        int min;
        while(true){
            min = idx;
            int left = idx*2+1;
            int right = idx*2+2;
            if(left<size && minheap[left]<minheap[min]){//防止溢出,找最小
                min = left;
            }
            if(right<size && minheap[right]<minheap[min]){//防止溢出
                min = right;
            }
            if(idx==min)
                return;
            swap(idx,min);
            idx = min;
        }
    }
    private void offerHeap(int x){
        minheap[size++]=x;
        Up(size-1);
    }
    private  void Up(int idx){
        while(idx>0){
            int parent = (idx-1)/2;//符合计算要求
            if(minheap[parent]<=minheap[idx])//max
                break;
            swap(idx,parent);
            idx = parent;
        }
    }

    private void swap(int l,int r){
        int temp = minheap[l];
        minheap[l]=minheap[r];
        minheap[r]=temp;
    }
}

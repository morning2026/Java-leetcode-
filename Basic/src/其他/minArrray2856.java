package 其他;

import java.util.List;
//注意到关键点是找众数，然后再引入二分查找
public class minArrray2856 {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int x = nums.get(nums.size()/2);
        int maxCount = Find(nums,x+1)-Find(nums,x)+1;//长度就是个数
        if(2*maxCount>nums.size()){
            return 2*maxCount - nums.size();
        }else {
            return nums.size()%2;
        }
        /*int maxCount = 0;
        int cur = 0;
        int len = nums.size();
        int last = 0;
        for(int i=0;i<len;i++){
            int num = nums.get(i);
            if(last == num){
                cur++;
            }else {
                cur = 0;
            }
            last = num;
            if(maxCount<cur+1) {
                maxCount = cur + 1;
            }
        }
        if(2*maxCount>len){
            return 2*maxCount - len;
        }else {
            return len%2;
        }*/
    }
    int Find(List<Integer> nums,int target){
        int left = 0;
        int right = nums.size();//左闭右开
        while (left<right){//标准二分就好
            int mid = ((right-left)>>1)+left;
            if(nums.get(mid)>=target)
                right = mid;
            else{
                left = mid + 1;//mid已经满足了
            }
        }
        return left;//+1
    }
}

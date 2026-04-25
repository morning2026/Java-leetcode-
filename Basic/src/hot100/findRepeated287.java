package hot100;
// 数组变链表，快慢指针
public class findRepeated287 {
    public int findDuplicate(int[] nums) {
    int slow=0,fast=0;
    do{// 防止初值问题
        slow=nums[slow];
        fast=nums[nums[fast]];
    }while(slow!=fast);
    fast = 0;
    while(slow!=fast){// 第二段
        slow=nums[slow];
        fast=nums[fast];
    }
    return slow;//是下标，两个指向同一个
    }
}

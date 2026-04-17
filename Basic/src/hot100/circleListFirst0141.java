package hot100;

public class circleListFirst0141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null && slow != null){
            fast = fast.next.next;// 注意第一个点
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}

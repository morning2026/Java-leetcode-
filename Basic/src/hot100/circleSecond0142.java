package hot100;

public class circleSecond0142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;// 注意第一个点
            slow = slow.next;
            if(fast == slow){
                meet = fast;
                break;
            }
        }
        if(meet == null) return null;
        slow = head;
        while(slow != meet){ //x=z
            slow = slow.next;
            meet = meet.next;
        }
        return meet;
    }
}

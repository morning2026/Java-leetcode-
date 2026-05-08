package hot100;

import hot100.List.ListNode;

public class circleSecond0142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null; // 用于标记
        while(fast != null && fast.next != null){
            fast = fast.next.next;// 注意第一个点
            slow = slow.next;
            if(fast == slow){
                meet = fast;
                break;
            }
        }
        if(meet == null) return null; //异常
        slow = head;
        while(slow != meet){ //x=z
            slow = slow.next;
            meet = meet.next;
        }
        return meet;
    }
}

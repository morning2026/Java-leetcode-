package hot100.List;

public class circleListFirst0141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null ){// 保证可以进入
            fast = fast.next.next;// 注意第一个点
            slow = slow.next;
            if(fast == slow){// 不能一开始就判断
                return true;
            }
        }
        return false;
    }
}

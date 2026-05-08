package hot100.List;

public class addNum002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        int cnt=0;
        while(l1 != null && l2 != null){
            cnt += l1.val +l2.val;
            ListNode l = new ListNode(cnt%10);
            cnt/=10;
            pre.next = l;
            pre = l;
            l1 = l1.next;//记得移动
            l2 = l2.next;
        }
        while(l1 != null){
            cnt += l1.val;
            ListNode l = new ListNode(cnt%10);
            cnt/=10;
            pre.next = l;
            pre = l;
            l1 = l1.next;
        }
        while(l2 != null){
            cnt += l2.val;
            ListNode l = new ListNode(cnt%10);
            cnt/=10;
            pre.next = l;
            pre = l;
            l2 = l2.next;
        }
        // 最高位维护
        if(cnt>0){
            ListNode l = new ListNode(cnt);
            pre.next = l;
        }
        return dummy.next;
    }
}

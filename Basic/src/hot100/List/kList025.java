package hot100.List;

import hot100.List.ListNode;

public class kList025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while(true){
            ListNode start = pre.next;
            ListNode end = pre;
            for(int i=0;i<k;i++){
                end = end.next;
                if(end == null) return dummy.next; // 后判防空
            }
            ListNode nextGroup = end.next;
            end.next = null;// 切断链表，精髓
            pre.next = reverse(start);
            start.next = nextGroup; // 挨个接回去，哪个接哪个别乱套
            pre = start;// 动指针
        }
    }
    private ListNode reverse(ListNode start){
        ListNode l = start;
        ListNode prev=null,next;
        while(l != null){
            next = l.next;
            l.next = prev;
            prev = l;
            l = next;
        }
        return prev;
    }

}

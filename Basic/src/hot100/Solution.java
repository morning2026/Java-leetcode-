package hot100;
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = head;
        int len = 0;
        while (pre != null){
            len++;
            pre =pre.next;
        }
        for(int i=1;i<len/2;i++){

        }
    }
    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val<=l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null?l2:l1;
        return dummy.next;
    }
}

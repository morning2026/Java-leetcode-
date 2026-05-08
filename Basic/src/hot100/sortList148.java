package hot100;

import hot100.List.ListNode;

public class sortList148 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = head;
        int len=0;
        while(pre != null){
            len++;
            pre = pre.next;
        }
        ListNode cur;
        for(int i=1;i<len;i*=2){
            pre = dummy;//每一轮重置
            cur = dummy.next;
            while(cur != null) {
                ListNode left = cur;
                ListNode right = cut(left, i);
                cur = cut(right, i);

                pre.next = merge(left,right); //接起来
                while(pre.next != null){ //是要尾结点
                    pre = pre.next;
                }
            }
        }
        return dummy.next;
    }
    private ListNode cut(ListNode head,int step){
        while(step>1 && head!= null){
            step--;
            head=head.next;
        }
        if(head == null) return null;
        ListNode next = head.next;
        head.next = null;
        return next;
    }

    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }
        if(l1 != null){
            cur.next = l1;
        }
        if(l2 != null){
            cur.next = l2;
        }
        return dummy.next;
    }
}

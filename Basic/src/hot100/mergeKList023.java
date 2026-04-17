package hot100;

public class mergeKList023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        return merge(lists,0,lists.length-1);
    }
    private ListNode merge(ListNode[] lists,int l,int r){
        if(l == r)
            return lists[l];
        int mid = l+((r-l)>>1);
        ListNode left = merge(lists,l,mid);
        ListNode right = merge(lists,mid+1,r);
        return mergeTwoLists(left,right);
    }
    private ListNode mergeTwoLists(ListNode l1,ListNode l2){
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

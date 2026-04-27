package hot100;
public class roundList234 {
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(fast != null && fast.next!= null){ //注意奇数
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = reverse(next);
        fast = head;
        slow = slow.next;
        while(slow != null){
            if(fast.val != slow.val) //比较数值
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    private ListNode reverse(ListNode begin){
        ListNode pre = null;
        ListNode cur = begin;
        while(cur != null){ //最后一个也要反转
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
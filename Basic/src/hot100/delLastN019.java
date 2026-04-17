package hot100;

public class delLastN019 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        int count = 0;
        while(count<n){
            fast = fast.next;
            count++;
        }
        ListNode slow = dummy;
        while(fast.next != null){ //尾结点标识
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next; //假如删掉头结点
    }

}

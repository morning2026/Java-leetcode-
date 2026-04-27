package hot100;

public class reverseList206 {
    class ListNode{
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val,ListNode nextNode){
            this.val = val;
            this.next = nextNode;
        }
    }
    private ListNode head;
    public reverseList206(){
        this.head = new ListNode(0);
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;//多一个记录，只能在头，null
        ListNode cur = head; // 头结点初始化了
        while(cur != null){ //这才是最后一个节点
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur; // 要的是原来的cur
            cur = next; // 先反转再迭代
        }
        return prev;// 尾巴变成头
    }
}

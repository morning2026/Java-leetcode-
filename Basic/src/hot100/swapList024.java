package hot100;

public class swapList024 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;// 虚拟头结点初始化
        ListNode n1,n2;
        ListNode pre = dummyNode;
        while(pre.next != null && pre.next.next != null){  //还有两个可以换
            n1 = pre.next;
            n2 = pre.next.next;
            ListNode nextNode = n2.next;
            n2.next = n1;
            n1.next = nextNode;
            pre.next = n2;
            pre = n1; //不要乱跳,注意不是next了
        }
        return dummyNode.next;
    }
}

package hot100;
class Node{
    int val;
    Node next;
    Node random;
    Node(int val,Node next,Node random){
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
public class randomList138 {
    public Node copyRandomList(Node head) {
        Node pre = head;
        Node copy;
        while(pre != null){
            copy = new Node(pre.val,pre.next,null);
            pre.next = copy;
            pre = copy.next;
        }
        pre = head;
        while(pre != null){
            copy = pre.next;
            if(pre.random != null) //逢next判空
                copy.random = pre.random.next;
            pre = copy.next;
        }
        Node dummy = new Node(-1,null,null);
        // 指针结点单独放避免混乱
        Node p = dummy;
        pre = head;
        while(pre != null){
            copy = pre.next;

            p.next = copy;
            p = copy; //新链表

            pre.next = copy.next;
            pre = pre.next;//原链表
        }
        return dummy.next;
    }
}

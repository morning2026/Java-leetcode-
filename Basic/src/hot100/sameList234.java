package hot100;
import java.util.Scanner;
//acm模式
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val,ListNode nextNode){
        this.val = val;
        this.next = nextNode;
    }
}
public class sameList234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){ // 快慢指针，先next再fast，以防null还要next，运算符正确吗，会导致空指针么
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) slow = slow.next;
        ListNode reverseHead = reverse(slow); // 必须反转链表
        fast = head;
        while(reverseHead != null){ // 最后一个结点也要判断
            if(fast.val != reverseHead.val) return false; // 要用上
            fast = fast.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode pre = null,next;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for(int i=0;i<4;i++){
            int a = sc.nextInt();
            cur.next = new ListNode(a);
            cur = cur.next;
        }
        sameList234 s = new sameList234();
        System.out.print(s.isPalindrome(dummy.next));
    }
}

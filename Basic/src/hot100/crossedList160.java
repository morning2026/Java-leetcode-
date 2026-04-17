package hot100;

public class crossedList160 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode preA = headA;// 不删除头结点，不需要虚拟节点
        ListNode preB = headB;
        int lenA=0,lenB=0;
        while(preA !=null){ //想好，是A还是A.next
            lenA++;
            preA = preA.next;
        }
        while(preB !=null){
            lenB++;
            preB = preB.next;
        }
        preA = headA;
        preB = headB;
        for(int i=0;i<lenA+lenB;i++){
            if(preA == preB)
                return preA;
            preA = preA.next;
            if(preA == null)
                preA = headB;
                preB = preB.next;
            if(preB == null)
                preB = headA;
            // 要挪动指针，是不是同个操作,先移动再判断
        }
        return null;
    }
}

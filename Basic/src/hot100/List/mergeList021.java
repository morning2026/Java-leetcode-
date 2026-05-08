package hot100.List;

public class mergeList021 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre =dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                pre.next = list1;
                pre = list1;
                list1 = list1.next;
            }
            else{
                pre.next = list2;
                pre = list2;
                list2 = list2.next;
            }
        }
        while(list1 != null){
            pre.next = list1;
            pre = list1;
            list1 = list1.next;
        }
        while(list2 != null){
            pre.next = list2;
            pre = list2;
            list2 = list2.next;
        }
        return dummy.next;
    }
}

package CodingInterviews;

/**
 * Created by qukan on 2017/8/16.
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        int lastValue = head.val;
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur!=null){
            if(prev.val==cur.val){
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}

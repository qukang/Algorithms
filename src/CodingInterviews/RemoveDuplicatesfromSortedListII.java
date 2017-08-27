package CodingInterviews;

/**
 * Created by qukan on 2017/8/17.
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode prev = FakeHead;
        ListNode cur = head;
        while(cur!=null){
            while(cur.next!=null&&cur.next.val==cur.val){
                cur = cur.next;
            }
            if(prev.next==cur){
                prev = prev.next;
            }else{
                prev.next = cur.next;
            }
            cur = cur.next;
        }
        return FakeHead.next;
    }
}

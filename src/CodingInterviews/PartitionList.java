package CodingInterviews;

/**
 * Created by qukan on 2017/8/16.
 */
public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode lefthead = left;
        ListNode righthead = right;
        ListNode p = head;
        while(p!=null){
            if(p.val<x){
                left.next = p;
                left = p;
            }else{
                right.next = p;
                right = p;
            }
            p = p.next;
        }
        left.next = righthead.next;
        right.next = null;
        return lefthead.next;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,3,4,2};
        int b = 4;
        ListNode alist = ListNode.LinkFactory(a);
        ListNode c = partition(alist,b);
        while(c!=null){
            System.out.println(c.val);
            c = c.next;
        }

    }
}

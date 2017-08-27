package CodingInterviews;

/**
 * Created by Omeprazole on 2017/5/6.
 */
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public static ListNode LinkFactory(int[] a){
        ListNode res = null;
        ListNode prev = null;
        if(a==null||a.length==0){
            return res;

        }
        for(int i = 0;i<a.length;i++){
            if(i==0){
                res = new ListNode(a[i]);
                prev = res;
            }else{
                prev.next = new ListNode(a[i]);
                prev = prev.next;
            }
        }
        return res;
    }
}

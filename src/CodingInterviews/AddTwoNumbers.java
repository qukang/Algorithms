package CodingInterviews;

import java.util.LinkedList;

/**
 * Created by qukan on 2017/8/15.
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = 0;
        int b = 0;
        ListNode res = null;
        ListNode prev = null;
        boolean flag = false;
        while(l1!=null||l2!=null||b!=0){
            if(l1!=null&&l2!=null){
                a = (l1.val+l2.val+b)%10;
                b = (l1.val+l2.val+b)/10;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1!=null){
                a = (l1.val+b)%10;
                b = (l1.val+b)/10;
                l1 = l1.next;
            }else if(l2!=null){
                a = (l2.val+b)%10;
                b = (l2.val+b)/10;
                l2 = l2.next;
            }else{
                a = b%10;
                b = b/10;
            }
            ListNode tmp = new ListNode(a);
            if(!flag){
                res = tmp;
                flag = true;
                prev = tmp;
            }else{
                prev.next = tmp;
                prev = tmp;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {2,4,3};
        int[] b = {5,6,4};
        ListNode alist = ListNode.LinkFactory(a);
        ListNode blist = ListNode.LinkFactory(b);
        ListNode clist = addTwoNumbers(alist,blist);
        while(clist!=null){
            System.out.println(clist.val);
            clist = clist.next;
        }
    }
}

/**
 * Created by qukan on 2017/5/6.
 */
public class 两个链表的第一个公共结点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = findNodeNumber(pHead1);
        int len2 = findNodeNumber(pHead2);
        int goFirst = 0;
        if(len1>len2){
            goFirst = len1-len2;
            while(goFirst!=0){
                pHead1 = pHead1.next;
                goFirst--;
            }
        }
        else{
            goFirst = len2-len1;
            while(goFirst!=0){
                pHead2 = pHead2.next;
                goFirst--;
            }
        }
        while(pHead1!=null&&pHead2!=null&&pHead1.val!=pHead2.val){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        if(pHead1==null||pHead2==null)
            return null;
        return pHead1;

    }

    public int findNodeNumber(ListNode p){
        ListNode q =  p;
        int count = 0;
        while(q!=null){
            count++;
            q = q.next;
        }
        return count;
    }

}

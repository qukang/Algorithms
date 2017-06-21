package CodingInterviews;

import java.util.Stack;

/**
 * Created by Omeprazole on 2017/5/4.
 */
public class 二叉搜索树与双向链表 {
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        TreeNode p = pRootOfTree;
        TreeNode pre = null;
        boolean isFirst = true;
        TreeNode root = null;
        Stack<TreeNode> st= new Stack<>();
        do{
            while(p!=null){
                st.push(p);
                p = p.left;
            }
            p = st.pop();
            if(isFirst){
                pre = p;
                isFirst = false;
                root = p;
            }else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }while(p!=null||!st.isEmpty());
        return root;
    }
    public static void main(String[] args){
        TreeNode p1 = new TreeNode(10);
        TreeNode p2 = new TreeNode(6);
        TreeNode p3 = new TreeNode(14);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(8);
        TreeNode p6 = new TreeNode(12);
        TreeNode p7 = new TreeNode(16);
        p1.left = p2;
        p1.right = p3;
        p2.left = p4;
        p2.right = p5;
        p3.left = p6;
        p3.right = p7;
        TreeNode p = Convert(p1);


    }
}

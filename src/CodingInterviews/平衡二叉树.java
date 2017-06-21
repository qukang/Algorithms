package CodingInterviews;

/**
 * Created by Omeprazole on 2017/5/8.
 */
public class 平衡二叉树 {
    public boolean IsBalanced_Solution(TreeNode root) {
        holder t = new holder();
        return IsBalanced(root,t);
    }

    public boolean IsBalanced(TreeNode root, holder h){
        if(root==null){
            h.d = 0;
            return true;
        }
        holder l = new holder();
        holder r = new holder();
        if(IsBalanced(root.left,l)&&IsBalanced(root.right,r)){
            if(((l.d-r.d)>1)||((r.d-l.d)>1)){
                return false;
            }
            h.d = l.d>r.d?(l.d+1):(r.d+1);
            return true;
        }
        return false;
    }

    private class holder{
        int d;
    }
}

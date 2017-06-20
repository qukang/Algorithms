import java.util.ArrayList;

/**
 * Created by qukan on 2017/5/8.
 */
public class 和为S的连续正数序列 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(sum<3){
            return res;
        }
        int begin = 1;
        int end = 2;
        int S;
        while(begin<=end&&end<=sum-1){
            S = (begin+end)*(end-begin+1)/2;
            if(S==sum){
                ArrayList<Integer> cur = new ArrayList<>();
                for(int i =begin ;i<=end;i++){
                    cur.add(i);
                }
                res.add(cur);
                begin = begin+1;
                end = end+1;
            }else if(S>sum){
                begin = begin+1;
            }else{
                end = end+1;
            }
        }
        return res;
    }
    public static void main(String [] args){
        int a = 9;
        和为S的连续正数序列 s= new 和为S的连续正数序列();
        s.FindContinuousSequence(a);
    }
}

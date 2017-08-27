package CodingInterviews;

/**
 * Created by qukan on 2017/8/16.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        int pre2 = 1;
        int pre1 = 2;
        int cur = 0;
        for(int i = 3;i<=n;i++){
            cur = pre1+pre2;
            pre1 = cur;
            pre2 = pre1;
        }
        return cur;
    }
}

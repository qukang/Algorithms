/**
 * Created by qukan on 2017/5/9.
 */
public class 孩子们的游戏圆圈中最后剩下的数 {
    public int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1){
            return -1;
        }
        int last = 0;
        for(int i =2;i<=n;i++){
            last = (last+m)%i;
        }
        return last;
    }

}

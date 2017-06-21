package CodingInterviews;

/**
 * Created by Omeprazole on 2017/5/9.
 */
public class 求123n {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }

    public static void main(String [] args){
        求123n s = new 求123n();
        int res = s.Sum_Solution(4);
        System.out.print(res);

    }
}
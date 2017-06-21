package CodingInterviews;

/**
 * Created by Omeprazole on 2017/5/4.
 */
public class 整数中1出现的次数 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int high,low,cur;
        int m = 0;
        high = n;
        int total = 0;
        int i = 1;
        while(high!=0){
            high = n/(int)Math.pow(10,i);
            low = n%(int)Math.pow(10,i-1);
            cur = (n%(int)Math.pow(10,i))/(int)Math.pow(10,i-1);
            if(cur==1){
                total+= high*(int)Math.pow(10,i-1)+low+1;
            }else if(cur>1){
                total+= (high+1)*(int)Math.pow(10,i-1);
            }else{
                total+= high*(int)Math.pow(10,i-1);
            }
            i++;
        }
        return total;
    }
}

package CodingInterviews;

import java.util.ArrayList;

/**
 * Created by Omeprazole on 2017/5/9.
 */
public class 和为S的两个数字 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int begin = 0;
        int end = array.length-1;
        ArrayList<Integer> res = new ArrayList<>();
        while(begin<=end){
            int s = array[begin]+array[end];
            if(s==sum){
                res.add(array[begin]);
                res.add(array[end]);
                break;
            }else if(s<sum){
                begin++;
            }else{
                end--;
            }
        }
        return res;
    }
}

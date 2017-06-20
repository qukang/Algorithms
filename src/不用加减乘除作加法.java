/**
 * Created by qukan on 2017/5/9.
 */
public class 不用加减乘除作加法 {
    public int Add(int num1,int num2) {
        int a = num1;
        int b = num2;
        int sum,carry;
        do{
            sum = a ^ b;
            carry = (a&b)<<1;
            a = sum;
            b = carry;
        }while (b!=0);
        return a;
    }
}

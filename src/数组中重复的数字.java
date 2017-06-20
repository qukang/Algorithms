import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by qukan on 2017/5/10.
 */
public class 数组中重复的数字 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers.length<=0){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        boolean flag = false;
        for(int i:numbers){
            if(set.contains(i)){
               flag = true;
               duplication[0] = i;
            }else{
                set.add(i);
            }
        }
        return flag;
    }

    public static void main(String [] args){
        数组中重复的数字 s = new 数组中重复的数字();
        int[] a = new int[0];
        int[] b = new int[1];
        boolean aaa = s.duplicate(a,0,b);
        System.out.print(b);
    }
}

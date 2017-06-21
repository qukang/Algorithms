package CodingInterviews;

/**
 * Created by Omeprazole on 2017/5/8.
 */
public class 数组中只出现一次的数字 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int a = 0;
        for(int i=0;i< array.length;i++){
            a = a^array[i];
        }
        int index = firstOne(a);
        int first = 0;
        int second = 0;
        for(int i= 0 ;i<array.length;i++){
            if(isOne(array[i],index)){
                first = first^array[i];
            }else{
                second = second^array[i];
            }
        }
        num1[0] = first;
        num2[0] = second;
    }

    public static boolean isOne(int a,int i){
        int b = a>>i;
        if((b&0x01)!=0){
            return true;
        }else{
            return false;
        }
    }

    public static int firstOne(int a){
        int index = 0;
        while((a&0x01)==0){
            a = a>>1;
            index++;
        }
        return index;
    }
}

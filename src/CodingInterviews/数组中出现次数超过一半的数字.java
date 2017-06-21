package CodingInterviews;

/**
 * Created by Omeprazole on 2017/5/4.
 */
public class 数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length==0){
            return 0;
        }
        int target = array[0];
        int flag = 1;
        for(int i =1;i<array.length;i++){
            if(flag==0){
                target=array[i];
                flag = 1;
            }
            else if(target!=array[i]){
                flag--;
            }else{
                flag++;
            }
        }
        if(flag<=0){
            return 0;
        }
        flag=0;
        for(int i = 0;i< array.length;i++){
            if(target==array[i]){
                flag++;
            }
        }
        if(flag> array.length/2){
            return target;
        }
        return 0;
    }
}

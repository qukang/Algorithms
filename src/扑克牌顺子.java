import java.util.Arrays;

/**
 * Created by qukan on 2017/5/9.
 */
public class 扑克牌顺子 {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length==1){
            return true;
        }
        if(numbers.length==0){
            return false;
        }
        Arrays.sort(numbers);
        int flag = 0;
        boolean first = true;
        boolean res = true;
        for(int i = 0;i<numbers.length;i++){
            if(numbers[i]==0){
                flag++;
            }
            else if(first){
                first = false;
            }else{
                if(numbers[i] != numbers[i-1]+1){
                    flag -= numbers[i]-numbers[i-1]-1;
                    if(flag<0||numbers[i]==numbers[i-1]){
                        res = false;
                        break;
                    }
                }
            }
        }
        return res;
    }
}

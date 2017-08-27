package CodingInterviews;

/**
 * Created by qukan on 2017/8/16.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int all = 0;
        int sum = 0;
        for(int i = 0;i<gas.length;i++){
            int diff = gas[i]-cost[i];
            all += diff;
            if(sum<0){
                start = i;
                sum = diff;
            }else{
                sum += diff;
            }
        }
        return all<0?-1:start;
    }
}

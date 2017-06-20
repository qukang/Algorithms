/**
 * Created by qukan on 2017/5/4.
 */
public class 连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        int[] dp = new int[len];
        dp[0] = array[0];
        for(int i = 1;i<len;i++){
            if(dp[i-1]>0){
                dp[i] = dp[i-1]+array[i];
            }else{
                dp[i] = array[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<len;i++){
            if(dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }
}

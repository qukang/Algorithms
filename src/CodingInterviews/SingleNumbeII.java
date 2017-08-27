package CodingInterviews;

/**
 * Created by qukan on 2017/8/16.
 */
public class SingleNumbeII {
    public int singleNumber(int[] nums) {
        int[] count = new int [32];
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<32;j++){
                count[j]+=(nums[i]>>j)&1;
                count[j]%=3;
            }
        }
        int result = 0;
        for(int i = 0;i<32;i++){
            result += (count[i]<<i);
        }
        return result;
    }
}

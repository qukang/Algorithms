package CodingInterviews;

import java.util.Arrays;

/**
 * Created by qukan on 2017/8/10.
 */
public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int N = nums.length;
        int[] max = new int[N];
        int[] min = new int[N];
        max[0] = nums[0];
        min[0] = nums[0];

        for(int i = 1;i<N;i++){
            int a = max[i-1]*nums[i];
            int b = min[i-1]*nums[i];
            max[i] = Math.max(Math.max(a,nums[i]),b);
            min[i] = Math.min(Math.min(a,nums[i]),b);
        }

        int res = Integer.MIN_VALUE;
        for(int i = 0;i<N;i++){
            if(res<max[i]){
                res = max[i];
            }
            if(res<min[i]){
                res = min[i];
            }
        }

        return res;


    }

    public static void main(String[] args) {
        int[] i = {-1,-2,-9,-6};
        System.out.println(maxProduct(i));
    }
}

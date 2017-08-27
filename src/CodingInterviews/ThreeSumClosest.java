package CodingInterviews;

import java.util.Arrays;

/**
 * Created by qukan on 2017/8/15.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int gap = Integer.MAX_VALUE;
        int res = 0;
        int N= nums.length;
        if(N<3) return -1;
        Arrays.sort(nums);
        for(int i = 0;i < N-2;i++){
            int l = i+1;
            int r = N-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                int curGap = Math.abs(sum-target);
                if(curGap<gap){
                    gap = curGap;
                    res = sum;
                }
                if(sum>target){
                    r--;
                }else if(sum<target){
                    l++;
                }else{
                    return sum;
                }
            }
        }
        return res;
    }
}

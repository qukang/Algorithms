package CodingInterviews;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by qukan on 2017/8/14.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap();
        int[] res = new int[2];
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                res[0]=map.get(target-nums[i]);
                res[1]=i;
                break;
            }else{
                map.put(nums[i],i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] res = twoSum(nums,6);
        for(int a :res ){
            System.out.println(a);
        }
    }
}

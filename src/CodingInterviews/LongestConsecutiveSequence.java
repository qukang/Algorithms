package CodingInterviews;

import java.util.HashMap;

/**
 * Created by qukan on 2017/8/15.
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        int N = nums.length;
        if(N==0) return 0;
        int l = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<N;i++){
            if(map.containsKey(nums[i])){
                continue;
            }
            int left = (map.containsKey(nums[i]-1))?map.get(nums[i]-1):0;
            int right = (map.containsKey(nums[i]+1))?map.get(nums[i]+1):0;
            int sum = left+right+1;
            map.put(nums[i],sum);
            map.put(nums[i]-left,sum);
            map.put(nums[i]+right,sum);
            l = Math.max(l,sum);
        }
        return l;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,2,4};
        System.out.println(longestConsecutive(a));
    }
}

package CodingInterviews;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qukan on 2017/8/15.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new LinkedList<>();
        if(nums.length<3){
            return res;
        }
        Arrays.sort(nums);
        int N= nums.length;
        for(int i =0;i<N-2;i++){
            int l = i+1;
            int r = N-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r]==0){
                    List<Integer> tmp = new LinkedList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    res.add(tmp);
                    while(l<r&&nums[l]==nums[l+1]){
                        l++;
                    }
                    while(l<r&&nums[r]==nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }else if(nums[i]+nums[l]+nums[r]<0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        HashSet set = new HashSet(res);
        res.clear();
        res.addAll(set);
        return res;
    }
}

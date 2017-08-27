package CodingInterviews;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qukan on 2017/8/15.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length<4){
            return res;
        }
        Arrays.sort(nums);
        int N= nums.length;
        for(int i =0;i<N-3;i++){
            for(int j = i+1;j<N-2;j++){
                int l = j+1;
                int r = N-1;
                while(l<r){
                    int sum = nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum==target){
                        List<Integer> tmp = new LinkedList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
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
                    }else if(sum<target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }

        }
        HashSet set = new HashSet(res);
        res.clear();
        res.addAll(set);
        return res;
    }
}

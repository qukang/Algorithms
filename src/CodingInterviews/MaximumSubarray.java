package CodingInterviews;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by qukan on 2017/8/25.
 */
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int tmp = nums[0];
        int res = tmp;
        for(int i = 1;i<nums.length;i++){
            if(tmp<=0){
                tmp = nums[i];
            }else{
                tmp = nums[i]+tmp;
            }
            if(res<tmp) res = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] arr = str.split(" ");
        int[] num = new int[arr.length];
        for(int i = 0; i< arr.length;i++){
            num[i]= Integer.valueOf(arr[i]);
        }
        int res = maxSubArray(num);

        System.out.print(res);

    }
}

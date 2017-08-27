package CodingInterviews;

/**
 * Created by qukan on 2017/8/15.
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int N = nums.length;
        int i =0;
        if(nums.length<=1) return;
        i = N-2;
        while(i!=-1&&nums[i]>=nums[i+1]){
            i--;
        }
        if(i==-1){
            reverse(nums,0,N-1);
        }else{
            int par = i;
            i = N-1;
            while(i!=-1&&nums[i]<=nums[par]){
                i--;
            }
            int s = i;
            swap(nums,par,s);
            reverse(nums,par+1,N-1);
        }

    }

    private static void reverse(int[] nums, int start,int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums,int i,int j){
        nums[i] = nums[i]^nums[j];
        nums[j] = nums[i]^nums[j];
        nums[i] = nums[i]^nums[j];
    }

    public static void main(String[] args) {
        int[] a = {1,5,1};
        nextPermutation(a);
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}

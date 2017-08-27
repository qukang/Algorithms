package CodingInterviews;

/**
 * Created by qukan on 2017/8/15.
 */
public class SearchinRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if(nums.length==0) return 0;
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = (l+r)>>1;
            if(nums[mid]==target) return mid;
            else if(nums[l]<=nums[mid]){
                if(nums[l]<=target&&target<=nums[mid]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }else{
                if(nums[mid]<target&&target<=nums[r]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {4,5,6,7,8,1,2,3};
        System.out.println(search(a,8));
    }
}

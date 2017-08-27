package CodingInterviews;

/**
 * Created by qukan on 2017/8/16.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int max = 0;
        int[] water = new int[height.length];
        int maxHeight = 0;
        for(int i =0;i<height.length;i++){
            if(maxHeight<height[i]){
                max = i;
                maxHeight = height[i];
            }
        }
        int left = 0;
        for(int i = 0;i<max;i++){
            if(height[i]>left){
                left = height[i];
            }else{
                water[i] = left-height[i];
            }
        }

        int right = 0;
        for(int i = height.length-1;i>max;i--){
            if(height[i]>right){
                right = height[i];
            }else{
                water[i] = right-height[i];
            }
        }

        int res = 0;
        for(int i =0;i<water.length;i++){
            res += water[i];
        }
        return res;
    }

}

package CodingInterviews;

import java.util.Stack;

/**
 * Created by qukan on 2017/8/25.
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        int area = 0;
        int[] h = new int[heights.length+1];
        for(int i = 0;i<heights.length;i++){
            h[i]=heights[i];
        }
        h[heights.length]=0;
        for(int i =0 ;i<h.length;i++){
            while(!st.isEmpty()&&h[st.peek()]>=h[i]){
                int cur = st.pop();
                area = h[cur]*(st.isEmpty()?i:(i-st.peek()-1));
                res = Math.max(area,res);
            }
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        LargestRectangleinHistogram a = new LargestRectangleinHistogram();
        int[] ar = new int[]{1};
        int b = a.largestRectangleArea(ar);
        System.out.println(b);
    }
}

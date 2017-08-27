package CodingInterviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qukan on 2017/8/24.
 */
public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size()-2;i>=0;i--){
            List<Integer> tmp = triangle.get(i);
            for(int j = 0;j<tmp.size();j++){
                int minValue = Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                tmp.set(j,minValue+tmp.get(j));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> all = new LinkedList<>();
        List<Integer> list1 = Arrays.asList(new Integer[]{-1});
        List<Integer> list2 = Arrays.asList(new Integer[]{2,3});
        List<Integer> list3 = Arrays.asList(new Integer[]{1,-1,-3});
        all.add(list1);
        all.add(list2);
        all.add(list3);
        int res = minimumTotal(all);
        System.out.println(res);
    }
}

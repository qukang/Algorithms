package CodingInterviews;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qukan on 2017/8/16.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new LinkedList<>();
        int sizeAll = 1<<n;
        for(int i = 0;i<sizeAll;i++){
            res.add(i^(i>>1));
        }
        return res;
    }
}

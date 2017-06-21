package CodingInterviews;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Omeprazole on 2017/5/4.
 */
public class 最小的k个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(k>input.length||k<=0){
            return result;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(k,lgcomp);
        for(int i=0 ;i<input.length;i++){
            if(heap.size()<k){
                heap.add(input[i]);
            }else{
                if(heap.peek()>input[i]){
                    heap.poll();
                    heap.add(input[i]);
                }
            }
        }

        result.addAll(heap);
        return result;
    }

    public static Comparator<Integer> lgcomp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    };
}

package CodingInterviews;

import java.util.ArrayList;

/**
 * Created by Omeprazole on 2017/5/5.
 */
public class 丑数 {
    public int GetUglyNumber_Solution(int index) {
        if(index<7) return index;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int[] ug = new int[index];
        ug[0] = 1;
        for(int i =1 ;i<index;i++){
            ug[i] = Min(ug[index2]*2,ug[index3]*3,ug[index5]*5);
            if(ug[i]==ug[index2]*2) index2++;
            if(ug[i]==ug[index3]*3) index3++;
            if(ug[i]==ug[index5]*5) index5++;
        }
        return ug[index-1];
    }
    public int Min(int a,int b,int c){
        int min = a<b?a:b;
        min = min<c?min:c;
        return min;
    }
}

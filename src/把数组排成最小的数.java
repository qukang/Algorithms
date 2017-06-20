import java.util.*;

/**
 * Created by qukan on 2017/5/4.
 */
public class 把数组排成最小的数 {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:numbers){
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                if((s1+s2).compareTo(s2+s1)>0){
                    return 1;
                }else if((s1+s2).compareTo(s2+s1)<0){
                    return -1;
                }else{
                    return 0;
                }
            }
        });

        String result = "";
        for(Integer i :list){
            result= result + String.valueOf(i);
        }
        return result;


    }
}

package CodingInterviews;

import java.util.HashMap;

/**
 * Created by Omeprazole on 2017/5/6.
 */
public class 第一个只出现一次的字符 {
    public int FirstNotRepeatingChar(String str) {
        if(str.length()==0||str==null){
            return -1;
        }
        HashMap<Character,Integer> map = new HashMap<>(str.length());
        for(int i =0 ;i<str.length();i++){
            char a = str.charAt(i);
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else{
                map.put(a,1);
            }
        }
        int res = 0;
        for(int i=0 ;i<str.length();i++){
            char a = str.charAt(i);
            if(map.get(a)!=1){
                res = i;
            }
        }
        return res;
    }
}

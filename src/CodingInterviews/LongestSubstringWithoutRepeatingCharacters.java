package CodingInterviews;

import java.util.HashMap;

/**
 * Created by qukan on 2017/8/15.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int maxlength = 0;
        int last = -1;
        int length = 0;
        HashMap<Character,Integer> map= new HashMap<Character,Integer>();
        for(int i = 0;i<s.length();i++){
            char cur = s.charAt(i);
            if(map.containsKey(cur)){
                last = map.get(cur)>last?map.get(cur):last;
            }
            length = i-last;
            if(maxlength<length){
                maxlength = length;
            }
            map.put(cur,i);
        }
        return maxlength;
    }

    public static void main(String[] args) {
        String a = "abba";
        System.out.println(lengthOfLongestSubstring(a));
    }
}

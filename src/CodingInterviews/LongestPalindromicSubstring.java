package CodingInterviews;

/**
 * Created by qukan on 2017/8/15.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int maxlength = 1;
        int start = 0;
        int len = s.length();
        boolean[][] a = new boolean[len][len];
        for(int i = 0;i<len;i++){
            a[i][i] = true;
            if(i<len-1&&s.charAt(i)==s.charAt(i+1)){
                a[i][i+1] = true;
                start = i;
                maxlength = 2;
            }
        }
        for(int l = 3;l<len;l++){
            for(int i = 0;i<len-l;i++){
                int j = l+l-1;
                if(a[i+1][j-1]&&s.charAt(i)==s.charAt(j)){
                    a[i][j]= true;
                    maxlength = l;
                    start = i;
                }
            }
        }
        return s.substring(start,start+maxlength);
    }
}

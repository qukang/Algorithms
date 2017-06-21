package CodingInterviews;

/**
 * Created by Omeprazole on 2017/5/9.
 */
public class 左旋转字符串 {
    public String LeftRotateString(String str,int n) {
        if(str==null||str.length()==0||str.length()<n){
            return "";
        }
        String str1 = str.substring(0,n);
        String str2 = str.substring(n,str.length());
        String res = str2+str1;
        return res;
    }

    public static void main(String [] args){
        String a = "abcdefg";
        int n = 3;
        左旋转字符串 s = new 左旋转字符串();
        String b = s.LeftRotateString(a,n);
        System.out.print(b);
    }
}

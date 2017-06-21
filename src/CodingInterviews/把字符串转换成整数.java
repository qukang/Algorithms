package CodingInterviews;

/**
 * Created by Omeprazole on 2017/5/9.
 */
public class 把字符串转换成整数 {
    public int StrToInt(String str) {
        if(str==null||str.length()==0){
            return 0;
        }
        if(str.length()==1&&(str.charAt(0)<'0'||str.charAt(0)>'9')){
            return 0;
        }
        boolean minus = false;
        int res = 0;
        boolean valid = true;
        for(int i = 0;i<str.length();i++){
            if(i==0){
                if(str.charAt(i)=='-'){
                    minus = true;
                }else if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                    res = res*10+str.charAt(i)-'0';
                }else if(str.charAt(i)=='+'){

                }else {
                    valid = false;
                    break;
                }
            }else{
                if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                    res = res*10+str.charAt(i)-'0';
                }else{
                    valid = false;
                    break;
                }
            }
        }
        if(valid){
            return minus?-res:res;
        }else{
            return 0;
        }
    }
}

/**
 * Created by qukan on 2017/5/9.
 */
public class 翻转单词序列 {
    public String ReverseSentence(String str) {
        if(str.length()==0) return "";
        if(str.trim().equals("")) return str;
        String a = new StringBuilder(str).reverse().toString();
        String[] b = a.split(" ");
        StringBuilder res = new StringBuilder();
        for(int i =0 ;i<b.length;i++){
            res.append(new StringBuilder(b[i]).reverse().toString());
            if(i!=b.length-1) res.append(" ");
        }
        return res.toString();
    }
}


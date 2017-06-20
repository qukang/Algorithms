import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by qukan on 2017/5/4.
 */
public class 字符串的排列 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str.length()==0||str==null){
            return result;
        }
        char[] ch = str.toCharArray();
        TreeSet<String> s = new TreeSet<String>();
        ArraysAll(ch,0,s);
        result.addAll(s);
        return result;

    }
    public void ArraysAll(char[] ch, int index, TreeSet<String> s){
        if(ch.length==0||ch==null||index<0||index>ch.length-1){
            return;
        }
        if(index==ch.length-1){
            s.add(String.valueOf(ch));
        }else{
            for(int i = index ;i<ch.length;i++){
                swap(ch,i,index);
                ArraysAll(ch,index+1,s);
                swap(ch,i,index);
            }
        }
    }
    public void swap(char[] ch,int index1,int index2){
        char temp = ch[index1];
        ch[index1] = ch[index2];
        ch[index2] = temp;
    }

    public static void main(String[] args){
        String a = "a";
        字符串的排列 solution = new 字符串的排列();
        ArrayList<String> b = solution.Permutation(a);

    }
}

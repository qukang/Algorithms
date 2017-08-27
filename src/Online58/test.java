package Online58;

/**
 * Created by qukan on 2017/8/22.
 */
public class test {

    public static int foo(int m){
        int n = 0;
        while(m!=0){
            ++n;
            m = (m-1)&m;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(foo(1234));
    }

}

/**
 * Created by qukan on 2017/8/26.
 */

class A{
    private final void P(){
        System.out.println("A");
    }
}
public class Test extends A{
    private static void f(int n,int i){

    }
    static int s;
    public static void main(String[] args) {
        final int i = 1;
        float j = 1;
        System.out.println(++j+i);
    }
}

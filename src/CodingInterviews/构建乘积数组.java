package CodingInterviews;

/**
 * Created by Omeprazole on 2017/5/10.
 */
public class 构建乘积数组 {
    public int[] multiply(int[] A) {
        int len = A.length;
        if(A.length<=1){
            return new int[len];
        }
        int [] B = new int[len];
        int [] C = new int[len];
        int [] D = new int[len];
        C[0] = 1;
        D[len-1] = 1;
        for(int i =1;i<len;i++){
            C[i] = C[i-1]*A[i-1];
            D[len-1-i] = D[len-i]*A[len-i];
        }
        for(int i =0 ;i<len;i++){
            B[i] = C[i]*D[i];
        }
        return B;
    }


    public  static  void  main(String[] args){
/*        String a = "12331524";
        char[] a1 = a.toCharArray();
        
        for(char b:a1){
            System.out.print(b);
        }*/
        for(int i = 0;i<10;i++){
            double tmp = Math.random();
            System.out.println(tmp);
        }
    }
}

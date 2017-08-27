import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    private static void add(int[] c,int k,int num){
        while(k<c.length){
            c[k] += num;
            k += k&-k;
        }
    }
    private static int read(int[] c,int k){
        int sum =0;
        while(k>0){
            sum+=c[k];
            k -= k&-k;
        }
        return sum;
    }
    public static ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        int []c = new int[10001];
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int cntofzero =0;
        for(int i=0;i<A.length;i++){
            if(A[i]>0){
                ans.add(read(c,A[i]-1)+cntofzero);
                add(c,A[i],1);
            }else{
                ans.add(0);
                cntofzero++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for(int i = 0;i<n;i++){
            score[i]=in.nextInt();
        }
        ArrayList<Integer> res = countOfSmallerNumberII(score);
        for(int i = 0;i<res.size()-1;i++){
            System.out.print(i-res.get(i));
            System.out.print(" ");
        }
        System.out.println(res.size()-1-res.get(res.size()-1));
    }
}

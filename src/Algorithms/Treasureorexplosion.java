package Algorithms; /**
 * Created by Omeprazole on 2017/5/25.
 */

import java.util.Scanner;

public class Treasureorexplosion {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        for(int i = 0;i<n;i++){
            int t = in.nextInt();
            arr[i] = t%m;
            sum+=arr[i];
        }
        if(sum==0){
            System.out.println("Yes");
        }else{
            boolean res = solveIt(arr,sum,m);
            if(res){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }

    }

    public static boolean solveIt(int[] arr,long sum, int m) {
        for(int j = m;j<=sum;j+=m){
            boolean result = getResult(arr,j);
            if(result){
                return true;
            }
        }
        return false;
    }

    public static boolean getResult(int[] arr, int m){
        int len = arr.length;
        int[] dp = new int[m+1];
        dp[0] = 1;
        for(int i = 1;i<=len;i++){
            dp[i] = 0;
        }

        for(int i = 0; i < len; i++) {
            for (int j = m; j >= arr[i]; j--)
            {
                if (dp[j] < dp[j - arr[i]])
                {
                    dp[j] = dp[j - arr[i]];
                }
            }
        }
        return dp[m]==1;
    }

}

package Algorithms; /**
 * Created by Omeprazole on 2017/5/25.
 */

import java.util.Scanner;

public class Teambuilding {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        System.out.println(solve(line));
    }

    public static long solve(String s){
        int len = s.length();
        long[][] dp = new long[len][len];
        for(int j = 0;j<len;j++){
            dp[j][j] = 1;
            for(int i = j-1;i>=0;i--){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j]+dp[i][j-1];
                }else{
                    dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
                }
            }
        }
        return dp[0][len-1];
    }



    public static long solve2(String s){
        int len = s.length();
        int ans = len;
        for(int i = 0;i<len;i++){
            int l = i-1,r = i+1;
            while(l>=0&&r<len&&s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                ans++;
            }
        }
        return ans;
    }


}

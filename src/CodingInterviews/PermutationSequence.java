package CodingInterviews;

/**
 * Created by qukan on 2017/8/15.
 */
public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        int p = 1;
        int[] num = new int[n];
        for(int i = 0;i<n;i++){
            num[i] = i+1;
            p*=(i+1);
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            p = p/(n-i);
            sb.append(num[k/p]);
            for(int j = k/p ; j < n - i - 1 ; j++){
                num[j] = num[j+1];
            }
            k = k%p;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3,4));
    }
}

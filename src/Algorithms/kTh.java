import java.util.Arrays;
import java.util.Scanner;

public class kTh {

   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int k = sc.nextInt();
            String[] sa = str.split(" ");
            int size = sa.length;
            int[] num = new int[size];
            for (int i = 0; i < size; i++) {
                num[i] = Integer.valueOf(sa[i]);
            }
            int res = getK(num, 0, size - 1, k);
            System.out.println(res);
        }
        sc.close();

        Arrays.sort();
    }

    public static int partition(int[] a, int lo, int hi) {
        int key = a[lo];
        while (lo < hi) {
            while (lo < hi && a[hi] <= key) {
                --hi;
            }
            a[lo] = a[hi];
            while (lo < hi && a[lo] >= key) {
                lo++;
            }
            a[hi] = a[lo];
        }
        a[lo] = key;
        return lo;
    }

    private static int getK(int[] a, int lo, int hi, int k) {
        int pos = partition(a, lo, hi);
        while (pos != k - 1) {
            if (pos > k - 1) {
                hi = pos - 1;
                pos = partition(a, lo, hi);
            } else {
                lo = pos + 1;
                pos = partition(a, lo, hi);
            }
        }
        return a[pos];
    }*/
}
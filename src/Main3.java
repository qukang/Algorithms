/**
 * Created by qukan on 2017/8/26.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main3 {
    static Node ns[];
    static int ts[];
    static int rs[];
    static int len;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(br);

    public static void main(String args[]) {
         len = sc.nextInt();

            //初始化
            ns = new Node[len];
            rs = new int[len + 1];
            ts = new int[len + 1];

            Arrays.fill(rs, 0);
            Arrays.fill(ts, 0);

            for (int i = 0; i < len; i++) {
                ns[i] = new Node();
                ns[i].value = sc.nextInt();
                ns[i].pos = i + 1;
            }
            // 离散化，即进行映射，
            Arrays.sort(ns, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.value - o2.value;
                }
            });
            for (int i = 0; i < len; i++) {
                rs[ns[i].pos] = i + 1;
            }

            //计算逆序数
            int sum = 0;
            for (int i = 1; i <= len; i++) {
                update(rs[i]);
                System.out.print(i - sum(rs[i]));
                System.out.print(" ");
            }
        }
    //求最低位1的位置
    public static int lowbit(int x) {
        return x & (-x);
    }
    //树状数组向后更新
    public static void update(int pos) {
        while (pos <= len) {
            ts[pos] += 1;
            pos += lowbit(pos);
        }
    }
    //树状数组向前求和
    public static int sum(int pos) {
        int sum = 0;
        while (pos > 0) {
            sum += ts[pos];
            pos -= lowbit(pos);
        }
        return sum;
    }
}
class Node {
    int value;
    int pos;

    @Override
    public String toString() {
        return "Node [value=" + value + ", pos=" + pos + "]";
    }
}
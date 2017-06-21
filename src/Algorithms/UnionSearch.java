package Algorithms;

/**
 * Created by Omeprazole on 2017/6/5.
 */
public class UnionSearch {
    public int[] pre;
    public int[] size;
    private int count;

    public UnionSearch(int n){
        pre = new int[n];
        for(int i = 0;i<n;i++){
            pre[i] = i;
        }
        size = new int[n];
        for(int i = 0;i<n;i++){
            size[i] = i;
        }
        count = n;
    }

    public int getCount(){
        return count;
    }

    public int find(int p){
        int a = p;
        while(a!=pre[a]){
            a = pre[a];
        }
        int q = p;
        int temp;
        while(pre[q]!=a){
            temp = pre[q];
            pre[q] = a;
            q = temp;
        }
        return a;
    }

    public void union(int p,int q){
        int a = find(p);
        int b = find(q);
        if(a!=b){
            if(size[a]>size[b]){
                pre[b] = a;
                size[a] += size[b];
            }else{
                pre[a] = b;
                size[b] += size[a];
            }
            count--;
        }
    }

    public boolean connected(int p,int q){
        return find(p)==find(q);
    }

    public static void main(String[] args){
        UnionSearch u = new UnionSearch(10);
        u.union(9,0);
        u.union(3,4);
        u.union(5,8);
        u.union(7,2);
        u.union(2,1);
        u.union(5,7);
        u.union(0,3);
        u.union(4,2);
        for(int i = 0;i<10;i++){
            System.out.println(u.find(i));
        }
        System.out.print(u.connected(8,9));


    }
}

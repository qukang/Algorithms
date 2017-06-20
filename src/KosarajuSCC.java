import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by qukan on 2017/6/20.
 */
public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph G) {
        this.marked = new boolean[G.V()];
        this.id = new int[G.V()];
        this.count = 0;
        DirectedDepthFirstSearch dfs = new DirectedDepthFirstSearch(G.reverse());

        Stack<Integer> revPost = dfs.getReversePost();
        while(!revPost.isEmpty()){
            int v = revPost.pop();
            if(!marked[v]){
                dfs(G,v);
                count++;
            }
        }
    }


    private void dfs(Digraph G, int v){
        marked[v] = true;
        id[v] = count;
        for(int w: G.adj(v)){
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }

    public static void main(String[] args) {
        String fileName = "data/tinyDG.txt";
        //String fileName = "data/mediumG.txt";
        try {
            InputStream in = new FileInputStream(new File(fileName));
            Scanner scanner = new Scanner(in);
            Digraph graph = new Digraph(scanner);
            KosarajuSCC k = new KosarajuSCC(graph);
            System.out.println(k.count);
            LinkedList<LinkedList<Integer>> all = new LinkedList<>();
            for(int i = 0;i<graph.V();i++){
                LinkedList temp = new LinkedList<Integer>();
                all.push(temp);
            }
            for(int i = 0;i<graph.V();i++){
                all.get(k.id[i]).push(i);
            }

            for(LinkedList<Integer> li : all){
                for(Integer e:li){
                    System.out.print(e+" ");
                }
                System.out.print("\n");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }




}

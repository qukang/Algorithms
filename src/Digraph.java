import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by qukan on 2017/6/9.
 */
public class Digraph {
    private final int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Integer>[])new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public Digraph(BufferedReader reader) throws IOException{
        this(Integer.valueOf(reader.readLine()));
        int E = Integer.valueOf(reader.readLine());
        for(int i = 0;i<E;i++){
            String tmp_ = reader.readLine();
            String tmp = tmp_.trim();
            String[] strs = tmp.split(" ");
            int v = Integer.valueOf(strs[0]);
            int w = Integer.valueOf(strs[1]);
            addEdge(v,w);
        }
    }

    public Digraph(Scanner scanner) throws IOException{
        this(scanner.nextInt());
        int E = scanner.nextInt();
        for(int i = 0;i<E;i++){
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            addEdge(v,w);
        }
    }

    public Digraph reverse(){
        Digraph R = new Digraph(V);
        for(int v = 0;v<V;v++){
            for(int w: adj(v)){
                R.addEdge(w,v);
            }
        }
        return R;
    }


    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }


    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(V).append(" vertices, ").append(V).append(" edges\n");
        for(int v = 0;v<V;v++){
            builder.append(v).append(": ");
            for(int w:this.adj(v))
                builder.append(w).append(" ");
            builder.append("\n");
        }
        String s = builder.toString();
        return s;
    }

    public static void main(String[] args){
        String fileName = "data/tinyG.txt";
        //String fileName = "data/mediumG.txt";
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            Digraph graph = new Digraph(reader);
            System.out.print(graph.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}

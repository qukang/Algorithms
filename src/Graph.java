
import java.io.*;
import java.util.LinkedList;

/**
 * Created by qukan on 2017/6/9.
 */
public class Graph {
    private final int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Integer>[])new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public Graph(BufferedReader reader) throws IOException{
        this(Integer.valueOf(reader.readLine()));
        int E = Integer.valueOf(reader.readLine());
        for(int i = 0;i<E;i++){
            String tmp = reader.readLine();
            String[] strs = tmp.split(" ");
            int v = Integer.valueOf(strs[0]);
            int w = Integer.valueOf(strs[1]);
            addEdge(v,w);
        }
    }


    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public static int degree(Graph G,int v){
        int degree = 0;
        for(int w:G.adj(v)){
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph G){
        int max = 0;
        for(int v = 0;v<G.V();v++){
            if((degree(G,v)>max)){
                max = degree(G,v);
            }
        }
        return max;
    }

    public static double aveDegree(Graph G){
        return 2.0*G.E()/G.V();
    }

    public static int numberOfSelfLoops(Graph G){
        int count = 0;
        for(int v = 0;v<G.V();v++){
            for(int w:G.adj(v)){
                if(v==w) count++;
            }
        }
        return count/2;
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
            Graph graph = new Graph(reader);
            System.out.print(graph.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}

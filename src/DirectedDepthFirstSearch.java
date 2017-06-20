import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

/**
 * Created by qukan on 2017/6/10.
 */
public class DirectedDepthFirstSearch {
    private boolean[] marked;

    public DirectedDepthFirstSearch(Digraph G, int v){
        marked = new boolean[G.V()];
        dfs(G,v);
    }

    public DirectedDepthFirstSearch(Digraph G, Iterable<Integer> sources){
        marked = new boolean[G.V()];
        for(int v:sources){
            if(!marked[v]){
                dfs(G,v);
            }
        }
    }

    public DirectedDepthFirstSearch(Digraph G){
        marked = new boolean[G.V()];
        for(int v = 0;v<G.V();v++){
            if(!marked[v]){
                dfs(G,v);
            }
        }
    }

    private void dfs(Digraph G,int t){
        marked[t]=true;
        for(int v :G.adj(t)){
            if(!marked[v]){
                dfs(G,v);
            }
        }
    }


    public boolean getMarked(int w){
        return marked[w];
    }


    public static void main(String[] args){

        String fileName = "data/tinyG.txt";
        //String fileName = "data/mediumG.txt";
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            Digraph graph = new Digraph(reader);
            System.out.print(graph.toString());
            DirectedDepthFirstSearch search = new DirectedDepthFirstSearch(graph,0);
            for(int i = 0;i<graph.V();i++){
                if(search.marked[i]){
                    System.out.print(i+" ");
                }
            }
            System.out.println();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

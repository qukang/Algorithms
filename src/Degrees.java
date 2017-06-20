import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * Created by qukan on 2017/6/20.
 */
public class Degrees {
    private int[] indegree;
    private int[] outdegree;
    private Queue<Integer> sources;
    private Queue<Integer> sinks;


    public Degrees(Digraph G){
        indegree = new int[G.V()];
        outdegree = new int[G.V()];
        sources = new LinkedList<>();
        sinks = new LinkedList<>();
        for(int v = 0;v<G.V();v++){
            for(int w:G.adj(v)){
                indegree[w]++;
                outdegree[v]++;
            }
        }
    }

    public int indegree(int v){
        return indegree[v];
    }

    public int outdegree(int v){
        return indegree[v];
    }

    public Queue<Integer> sources(){
        for(int i = 0;i<indegree.length;i++){
            if(indegree[i]==0){
                sources.offer(i);
            }
        }
        return sources;
    }

    public Queue<Integer> sinks(){
        for(int i = 0;i<outdegree.length;i++){
            if(outdegree[i]==0){
                sinks.offer(i);
            }
        }
        return sinks;
    }

    public boolean isMap(){
        for(int i:outdegree){
            if(i!=1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String fileName = "data/tinyDAG.txt";
        //String fileName = "data/mediumG.txt";
        try {
            InputStream in = new FileInputStream(new File(fileName));
            Scanner scanner = new Scanner(in);
            Digraph graph = new Digraph(scanner);
            Degrees degrees = new Degrees(graph);
            Queue<Integer> sources = degrees.sources();
            Queue<Integer> topological = new LinkedList<>();
            while(!sources.isEmpty()){
                int cur = sources.poll();
                topological.offer(cur);
                for(int w:graph.adj(cur)){
                    degrees.indegree[w]--;
                    if(degrees.indegree[w]==0){
                        sources.offer(w);
                    }
                }
            }
            for( int t :topological){
                System.out.println(t);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }



}

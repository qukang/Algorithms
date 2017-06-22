package Algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Omeprazole on 2017/6/21.
 */
public class primeMST implements MST {
    private boolean[] marked;
    private Edge[] edgeTo;
    private double[] distTo;
    private TreeMap<Integer,Double> pq;

    public primeMST(EdgeWeightedGraph G) {
        marked = new boolean[G.V()];
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        pq = new TreeMap<Integer,Double>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if(pq.get(o1)>pq.get(o2)){
                            return 1;
                        }else if(pq.get(o1)<pq.get(o2)){
                            return -1;
                        }else{
                            return 0;
                        }
                    }
                }
        );
        for(int i = 0;i<G.V();i++){
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[0] = 0;
        pq.put(0,0.0);
        while(!pq.isEmpty())
            visit(G,pq.firstKey());
    }

    private void visit(EdgeWeightedGraph G,int v){
        marked[v] = true;
        for(Edge e : G.adj(v)){
            int w = e.other(v);
            if(marked[w]) continue;
            if(e.getWeight()<distTo[w]){
                distTo[w] = e.getWeight();
                edgeTo[w] = e;
                pq.put(w,distTo[w]);
            }
        }
    }


    @Override
    public Iterable<Edge> edges(){
        LinkedList<Edge> res = new LinkedList<>();
        for(Edge e:edgeTo){
            res.push(e);
        }
        return res;
    }

    @Override
    public double weight(){
        double weight = 0.0;
        for(Edge e:edgeTo){
            weight+=e.getWeight();
        }
        return weight;
    }


    public static void main(String[] args) {
        String fileName = "data/tinyEWG.txt";
        try{
            InputStream in = new FileInputStream(new File(fileName));
            Scanner scanner = new Scanner(in);
            EdgeWeightedGraph G = new EdgeWeightedGraph(scanner);
            primeMST mst = new primeMST(G);
            System.out.print(mst.weight());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

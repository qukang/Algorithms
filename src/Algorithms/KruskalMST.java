package Algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Omeprazole on 2017/6/22.
 */
public class KruskalMST implements MST {

    private LinkedList<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new LinkedList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(Edge e:G.edges()) pq.add(e);
        UnionSearch u = new UnionSearch(G.V());

        while(!pq.isEmpty()&&mst.size()<G.V()-1){
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);
            if(!u.connected(v,w)){
                mst.push(e);
                u.union(v,w);
            }
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return mst;
    }

    @Override
    public double weight() {
        double weight = 0.0;
        for(Edge e:mst){
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
            KruskalMST mst = new KruskalMST(G);
            System.out.print(mst.edges());
            System.out.print(mst.weight());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

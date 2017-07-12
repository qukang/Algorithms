package Algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Omeprazole on 2017/6/22.
 */
public class EdgeWeightedDigrpah {

    private final int V;
    private int E:
    private LinkedList<DirectedEdge>[] adj;
    private HashSet<DirectedEdge> edges;

    public EdgeWeightedDigrpah(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (LinkedList<DirectedEdge>[]) new LinkedList[V];
    }

    public EdgeWeightedDigrpah(Scanner scanner){
        this(scanner.nextInt());
        int E = scanner.nextInt();
        for(int i = 0;i<E;i++){
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            double weight = scanner.nextDouble();
            DirectedEdge e = new DirectedEdge(v,w,weight);
            addEdge(e);
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    private void addEdge(DirectedEdge e){
        int v = e.from();
        adj[v].push(e);
        edges.add(e);
        E++;
    }

    Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }

    Iterable<DirectedEdge> edges(){
        return edges;
    }

    @Override
    public String toString() {
        return "EdgeWeightedDigrpah{" +
                "V=" + V +
                ", E=" + E +
                ", adj=" + Arrays.toString(adj) +
                ", edges=" + edges +
                '}';
    }
}

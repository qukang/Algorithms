package Algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Omeprazole on 2017/6/21.
 */
public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private LinkedList<Edge>[] adj;
    private HashSet<Edge> edges;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Edge>[]) new LinkedList[];
        for(int i = 0;i<V;i++){
            adj[i] = new LinkedList<>();
        }
    }

    public EdgeWeightedGraph(Scanner scanner) {
        this(scanner.nextInt());
        this.E = scanner.nextInt();
        for(int i = 0;i<E;i++){
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            double weight = scanner.nextDouble();
            Edge e = new Edge(v,w,weight);
            addEdge(e);
        }
    }

    private void addEdge(Edge e){
        int either = e.either();
        int other = e.other(either);
        adj[either].addLast(e);
        adj[other].addLast(e);
        edges.add(e);
    }

    public int V(){
        return this.V;
    }

    public int E(){
        return this.E;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public Iterable<Edge> edges(){
        return edges;
    }

    @Override
    public String toString() {
        return "Algorithms.EdgeWeightedGraph{" +
                "V=" + V +
                ", E=" + E +
                ", adj=" + Arrays.toString(adj) +
                ", edges=" + edges +
                '}';
    }
}

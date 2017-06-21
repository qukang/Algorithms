package Algorithms;

/**
 * Created by Omeprazole on 2017/6/21.
 */
public class Edge implements Comparable<Edge> {
    private int v;
    private int w;
    private double weight;

    @Override
    public int compareTo(Edge o) {
        if(this.getWeight()>o.getWeight()) return 1;
        else if(this.getWeight() <o.getWeight()) return -1;
        else return 0;
    }

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    public int either(){
        return v;
    }

    public int other(int v){
        if(v==this.w) return this.v;
        else if(v==this.v) return this.w;
        else return -1;
    }

    @Override
    public String toString() {
        return "Algorithms.Edge{" +
                "w=" + w +
                ", v=" + v +
                ", weight=" + weight +
                '}';
    }
}

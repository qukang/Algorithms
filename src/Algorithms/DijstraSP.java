package Algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Omeprazole on 2017/7/6.
 */
public class DijstraSP
{

    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private LinkedList<Double> pq;


    public DijstraSP(EdgeWeightedDigrpah G,int s){
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new LinkedList;
        for(int v = 0;v<G.V();v++){
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0;
        pq.insert(s,0.0);
        while(!pq.isEmpty()){
            relax(G,pq.delMin());
        }
    }


    private void relax(EdgeWeightedDigrpah G,int v){
        for(DirectedEdge e :G.adj(v)){
            int w = e.to();
            if(distTo[w]>distTo[v]+e.getWeight()){
                distTo[w] = distTo[v] +e.getWeight();
                edgeTo[w] = e;
                if(pq.contains(w)) pq.change(w,distTo[w]);
                else pq.insert(w,distTo[w]);
            }
        }
    }

    public double distTo(int v){
        return distTo[v];
    }

    public boolean hasPathTO(v){
        if(distTo[v]<Double.POSITIVE_INFINITY){
            return true;
        }else{
            return false;
        }
    }

    public Stack<DirectedEdge> pathTO(int v){

    }




}

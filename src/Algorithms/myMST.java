package Algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Omeprazole on 2017/6/21.
 */
public class myMST implements MST {
    private double weight;

    public myMST(EdgeWeightedGraph G) {

    }

    @Override
    public Iterable<Edge> edges(){

    }

    @Override
    public double weight(){
        return this.weight;
    }

    public static void main(String[] args) {
        String fileName = "data/tinyG.txt";
        try{
            InputStream in = new FileInputStream(new File(fileName));
            Scanner scanner = new Scanner(in);
            EdgeWeightedGraph G = new EdgeWeightedGraph(scanner);
            myMST mst = myMST MST(G);
            System.out.print(mst.weight());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

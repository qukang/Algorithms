package Algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Omeprazole on 2017/6/10.
 */
public class DirectedDepthFirstSearch {
    private boolean[] marked;
    private LinkedList<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public LinkedList<Integer> getPre() {
        return pre;
    }

    public Queue<Integer> getPost() {
        return post;
    }

    public Stack<Integer> getReversePost() {
        return reversePost;
    }

    public DirectedDepthFirstSearch(Digraph G, int v){
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];

        dfs(G,v);
    }

    public DirectedDepthFirstSearch(Digraph G){
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];

        for(int v = 0;v<G.V();v++){
            if(!marked[v]){
                dfs(G,v);
            }
        }
    }

    public DirectedDepthFirstSearch(Digraph G, Iterable<Integer> sources){
        marked = new boolean[G.V()];
        for(int v:sources){
            if(!marked[v]){
                dfs(G,v);
            }
        }
    }



    private void dfs(Digraph G,int t){
        pre.add(t);

        marked[t]=true;
        for(int v :G.adj(t)){
            if(!marked[v]){
                dfs(G,v);
            }
        }

        post.add(t);
        reversePost.push(t);
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

import java.util.Stack;

/**
 * Created by qukan on 2017/6/11.
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] egedTo;
    private Stack<Integer> circle;
    private boolean[] onStack;

    public DirectedCycle(Digraph G, int s){
        marked = new boolean[G.V()];
        onStack  = new boolean[G.V()];
        circle = null;
        egedTo = new int[G.V()];
    }

    private void dfs(Digraph G, int v){
        marked[v]=true;
        for(int w : G.adj(v)){
            if(!marked[w]&&!onStack[v]){
                egedTo[w] = v;
                dfs(G,w);
            }
        }
    }

}

import java.util.Stack;

/**
 * Created by qukan on 2017/6/11.
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] egedTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph G){
        marked = new boolean[G.V()];
        onStack  = new boolean[G.V()];
        cycle = null;
        egedTo = new int[G.V()];
        for(int v = 0;v<G.V();v++){
            if(!marked[v])
                dfs(G,v);
        }
    }

    private void dfs(Digraph G, int v){
        marked[v]=true;
        onStack[v] = true;
        for(int w : G.adj(v)){
            if(hasCycle()){
                return;
            }
            else if(!marked[w]){
                egedTo[w] = v;
                dfs(G,w);
            }
            else if(onStack[w]){
                cycle = new Stack<>();
                for(int x = v; x != w; x = egedTo[x]){
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle(){
        return cycle!=null;
    }

    public Stack<Integer> getCycle(){
        return cycle;
    }

}

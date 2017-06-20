import java.util.Stack;

/**
 * Created by qukan on 2017/6/20.
 */
public class Topological {
    private Stack<Integer> order;

    public Topological(Digraph G){
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if(!cyclefinder.hasCycle()){
            DirectedDepthFirstSearch dfs = new DirectedDepthFirstSearch(G);
            order = dfs.getReversePost();
        }
    }

    public Stack<Integer> getOrder() {
        return order;
    }

    public boolean isDAG(){
        return order!=null;
    }

}

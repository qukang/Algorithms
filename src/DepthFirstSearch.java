import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

/**
 * Created by qukan on 2017/6/10.
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    private int[] edgeTo;
    private final int s;
    private int[] id;
    private int connectCount;


    public DepthFirstSearch(Graph G,int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        id = new int[G.V()];
        count = 0;
        this.s = s;
        dfs(G,s);
    }


    public DepthFirstSearch(Graph G){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        id = new int[G.V()];
        connectCount = 0;
        count = 0;
        this.s = 0;
        for(int v = 0;v<G.V();v++){
            if(!marked[v]){
                connectCount++;
                dfs(G,v);
            }
        }
    }

    private void dfs(Graph G,int t){
        marked[t]=true;
        id[t] = connectCount;
        count++;
        for(int v :G.adj(t)){
            if(!marked[v]){
                edgeTo[v] = t;
                dfs(G,v);
            }
        }
    }

    public boolean connected(int v,int w){
        return id[v]==id[w];
    }

    public int getId(int v){
        return id[v];
    }

    public int getConnectCount(){
        return connectCount;
    }


    public Stack<Integer> pathTo(int v){
        if(!getMarked(v)){
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for(int x = v;x!=s;x=edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public boolean getMarked(int w){
        return marked[w];
    }

    public int getCount(){
        return count;
    }

    public static void main(String[] args){

        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        for(int i: st){
            System.out.print(i);
        }


        String fileName = "data/tinyG.txt";
        //String fileName = "data/mediumG.txt";
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            Graph graph = new Graph(reader);
            System.out.print(graph.toString());
            DepthFirstSearch search = new DepthFirstSearch(graph,0);
            for(int i = 0;i<graph.V();i++){
                if(search.marked[i]){
                    System.out.print(i+" ");
                }
            }
            System.out.println();
            if(search.count!=graph.V()){
                System.out.println("Not Connected");
            }else{
                System.out.println("Connected");
            }

            for(int i = 0;i<graph.V();i++){
                if(search.marked[i]){
                    Stack<Integer> temp = search.pathTo(i);
                    while(!temp.isEmpty()){
                        int x = temp.pop();
                        if(x==0) System.out.print(0);
                        else System.out.print("-"+x);
                    }
                }
                System.out.println();
            }
            System.out.println();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

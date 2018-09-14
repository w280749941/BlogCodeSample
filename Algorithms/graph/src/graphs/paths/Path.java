package graphs.paths;

import graphs.Graph;
import graphs.Iterator;
import java.util.ArrayList;
import java.util.List;

public class Path {

    private Graph graph;
    private int source;
    private boolean[] visited;
    private int[] from;

    public Path(Graph graph, int source){
        this.graph = graph;

        visited = new boolean[graph.getVertices()];
        from = new int[graph.getVertices()];
        for(int i=0; i<graph.getVertices(); i++){
            from[i] = -1;
        }
        this.source = source;

        // Search for path
        dfs(source);
    }

    public boolean hasPath(int destination){
        return visited[destination];
    }

    public void path(int destination, List<Integer> lt){
        ShortestPath.getPath(destination, lt, from);
    }

    public void showPath(int destination){
        List<Integer> lt = new ArrayList<>();
        path(destination, lt);
        ShortestPath.printPath(lt);
    }

    private void dfs(int v) {
        visited[v] = true;
        Iterator iterator = graph.getIterator(v);
        for(int i=iterator.start(); !iterator.end(); i=iterator.next()){
            if(!visited[i]){
                from[i] = v; // Visit i from v
                dfs(i);
            }
        }
    }
}

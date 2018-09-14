package graphs;

public class ConnectedGraph {

    private Graph graph;
    private boolean[] visited;
    public int count;
    private int[] id;

    public ConnectedGraph(Graph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.getVertices()];
        this.id = new int[graph.getVertices()];
        this.count = 0;
        for(int i=0; i<graph.getVertices(); i++){
            visited[i] = false;
            id[i] = -1;
        }

        for(int i=0; i<graph.getVertices(); i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        id[v] = count;
        Iterator iterator = graph.getIterator(v);
        for(int i=iterator.start(); !iterator.end(); i=iterator.next()){
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    boolean isConnected(int v, int w){
        return id[v] == id[w];
    }
}

package graphs;

public interface Graph {

    public int getVertices();
    public int getEdges();
    public void addEdge( int vertex1, int vertex2 ) throws Exception;
    boolean hasEdge( int vertex1, int vertex2 ) throws Exception;
    void show();
    public Iterator getIterator(int vertex);
}
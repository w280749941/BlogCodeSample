package graphs.densegraph;

import graphs.Graph;
import graphs.utils.Iterator;

public class DenseGraph implements Graph {

    private int vertices;
    private int edges;
    private boolean directed;
    private boolean[][] matrix;

    public DenseGraph (int vertices, boolean directed){
        this.vertices = vertices;
        this.edges = 0;
        this.directed = directed;
        matrix = new boolean[vertices][vertices];
    }


    public int getVertices(){
        return this.vertices;
    }

    public int getEdges(){
        return this.edges;
    }

    // Add an edge if not exist.
    public void addEdge(int vertex1, int vertex2) throws Exception {
        if(vertex1 < 0 || vertex1 > this.vertices || vertex2 < 0 || vertex2 > this.vertices){
            throw new Exception(String.format("Out of bound in addEdge vertex1: %d, vertex2: %d",
                vertex1, vertex2));
        }

        if(hasEdge(vertex1, vertex2)){
            return;
        }

        matrix[vertex1][vertex2] = true;
        if(!directed){
            matrix[vertex2][vertex1] = true;
        }

        edges++;
    }

    public boolean hasEdge(int vertex1, int vertex2) throws Exception {
        if(vertex1 < 0 || vertex1 > this.vertices || vertex2 < 0 || vertex2 > this.vertices){
            throw new Exception(String.format("Out of bound in addEdge vertex1: %d, vertex2: %d",
                vertex1, vertex2));
        }

        return matrix[vertex1][vertex2];
    }

    @Override
    public void show() {
        for( int i = 0 ; i < vertices; i ++ ){
            for( int j = 0 ; j < vertices; j ++ )
                System.out.print(matrix[i][j]+"\t");
            System.out.println();
        }
    }

    @Override
    public Iterator getIterator(int vertex) {
        return new matrixIterator(this, vertex);
    }

    public static class matrixIterator implements Iterator {

        private DenseGraph denseGraph;
        private int vertex;
        private int index;
        public matrixIterator(DenseGraph denseGraph, int vertex){
            this.denseGraph = denseGraph;
            this.vertex = vertex;
            this.index = 0;
        }

        public int start(){
            index = -1;
            return next();
        }

        public int next(){
            for(index += 1; index < denseGraph.getVertices(); index++){
                if(denseGraph.matrix[vertex][index])
                    return index;
            }
            return -1;
        }

        public boolean end(){
            return index >= denseGraph.getVertices();
        }
    }
}

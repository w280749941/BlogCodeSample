package graphs.sparsegraph;

import graphs.Graph;
import graphs.Iterator;
import java.util.ArrayList;
import java.util.List;

public class SparseGraph implements Graph {

    private int vertices;
    private int edges;
    private boolean directed;
    private List<List<Integer>> matrix;

    public SparseGraph (int vertices, boolean directed){
        this.vertices = vertices;
        this.edges = 0;
        this.directed = directed;
        this.matrix = new ArrayList<>();
        for(int i=0; i < vertices; i++){
            this.matrix.add(new ArrayList<>());
        }
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

        matrix.get(vertex1).add(vertex2);
        if(!directed){
            matrix.get(vertex2).add(vertex1);
        }

        edges++;
    }

    public boolean hasEdge(int vertex1, int vertex2) throws Exception {
        if(vertex1 < 0 || vertex1 > this.vertices || vertex2 < 0 || vertex2 > this.vertices){
            throw new Exception(String.format("Out of bound in addEdge vertex1: %d, vertex2: %d",
                vertex1, vertex2));
        }

        return matrix.get(vertex1).contains(vertex2);
    }

    @Override
    public void show() {
        for( int i = 0 ; i < vertices; i ++ ){
            System.out.print("vertex " + i + ":\t");
            if(i < 10)
                System.out.print("\t");
            for( int j = 0 ; j < matrix.get(i).size() ; j ++ )
                System.out.print(matrix.get(i).get(j) + "\t");
            System.out.println();
        }
    }

    @Override
    public Iterator getIterator(int vertex) {
        return new adjacentIterator(this, vertex);
    }

    public static class adjacentIterator implements Iterator {

        private SparseGraph sparseGraph;
        private int vertex;
        private int index;
        public adjacentIterator(SparseGraph sparseGraph, int vertex){
            this.sparseGraph = sparseGraph;
            this.vertex = vertex;
            this.index = 0;
        }

        public int start(){
            if(sparseGraph.matrix.get(vertex).size() > 0){
                return sparseGraph.matrix.get(vertex).get(0);
            }
            return -1;
        }

        public int next(){
            index++;
            if(index < sparseGraph.matrix.get(vertex).size()){
                return sparseGraph.matrix.get(vertex).get(index);
            }
            return -1;
        }

        public boolean end(){
            return index >= sparseGraph.matrix.get(vertex).size();
        }
    }
}

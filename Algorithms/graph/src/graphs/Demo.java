package graphs;

import graphs.densegraph.DenseGraph;
import graphs.densegraph.DenseGraph.matrixIterator;
import graphs.paths.Path;
import graphs.paths.ShortestPath;
import graphs.sparsegraph.SparseGraph;
import graphs.utils.ReadGraph;
import java.util.Random;
import graphs.sparsegraph.SparseGraph.adjacentIterator;

public class Demo {

    public static void loadRandomData() throws Exception {
        int vertices = 20;
        int edges = 100;

        Random random = new Random();

        SparseGraph sparseGraph = new SparseGraph(vertices, false);
        for(int i=0; i < edges; i++){
            int a = random.nextInt(vertices);
            int b = random.nextInt(vertices);
            sparseGraph.addEdge(a, b);
        }

        // O(E)
        for( int v=0; v < vertices; v++){
            System.out.print(v + " : ");
            adjacentIterator iterator = new adjacentIterator(sparseGraph, v);
            for(int w = iterator.start(); !iterator.end(); w = iterator.next()){
                System.out.print(w + " ");
            }
            System.out.println();
        }
        System.out.println();

        DenseGraph denseGraph = new DenseGraph(vertices, false);
        for(int i=0; i < edges; i++){
            int a = random.nextInt(vertices);
            int b = random.nextInt(vertices);
            denseGraph.addEdge(a, b);
        }

        // O(V2)
        for( int v=0; v < vertices; v++){
            System.out.print(v + " : ");
            matrixIterator iterator = new matrixIterator(denseGraph, v);
            for(int w = iterator.start(); !iterator.end(); w = iterator.next()){
                System.out.print(w + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {

        String fileName = "Graph2.txt";

        SparseGraph sparseGraph = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(sparseGraph, fileName);
        sparseGraph.show();
        System.out.println();

        //SparseGraph dfs: O(V+E), DenseGraph dfs: O(V^2)
        Path path = new Path(sparseGraph, 0);
        System.out.print("DFS : ");
        path.showPath(6);

        //SparseGraph dfs: O(V+E), DenseGraph dfs: O(V^2)
        ShortestPath shortestPath = new ShortestPath(sparseGraph, 0);
        System.out.print("BFS : ");
        shortestPath.showPath(3);
    }

    private static void showGraphs(String fileName) throws Exception {
        SparseGraph sparseGraph = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(sparseGraph, fileName);
        sparseGraph.show();
        ConnectedGraph connectedGraph1 = new ConnectedGraph(sparseGraph);
        System.out.printf("Sparse graph: %d\n", connectedGraph1.count);

        DenseGraph denseGraph = new DenseGraph(7, false);
        ReadGraph readGraph2 = new ReadGraph(denseGraph, fileName);
        denseGraph.show();
        ConnectedGraph connectedGraph2 = new ConnectedGraph(denseGraph);
        System.out.printf("Dense graph: %d\n", connectedGraph2.count);
    }
}

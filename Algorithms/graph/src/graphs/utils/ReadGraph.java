package graphs.utils;

import graphs.Graph;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class ReadGraph {

    private Scanner scanner;
    public ReadGraph(Graph graph, final String fileName) throws Exception {

        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        scanner = new Scanner(new BufferedInputStream(fis));
        int V = scanner.nextInt();
        int E = scanner.nextInt();
        for (int i = 0; i < E; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            assert v >= 0 && v < V;
            assert w >= 0 && w < V;
            graph.addEdge(v, w);
        }
    }
}

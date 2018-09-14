package graphs.paths;

import graphs.Graph;
import graphs.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ShortestPath {

    private Graph graph;
    private int source;
    private boolean[] visited;
    private int[] from;
    private int[] order;

    public ShortestPath(Graph graph, int source){
        this.graph = graph;

        visited = new boolean[graph.getVertices()];
        from = new int[graph.getVertices()];
        order = new int[graph.getVertices()];
        for(int i=0; i<graph.getVertices(); i++){
            from[i] = -1;
            order[i] = -1;
        }
        this.source = source;

        // Search for path
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;
        order[source] = 0;
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            Iterator iterator = graph.getIterator(vertex);
            for(int i=iterator.start(); !iterator.end(); i=iterator.next()){
                if(!visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                    from[i] = vertex;
                    order[i] = order[vertex]+1;
                }
            }
        }
    }

    public boolean hasPath(int destination){
        return visited[destination];
    }

    public void path(int destination, List<Integer> lt){
        getPath(destination, lt, from);
    }

    static void getPath(int destination, List<Integer> lt, int[] from) {
        Stack<Integer> st = new Stack<>();
        int goal = destination;
        while(goal != -1){
            st.push(goal);
            goal = from[goal];
        }

        lt.clear();
        while(!st.empty()){
            lt.add(st.pop());
        }
    }

    public void showPath(int destination){
        List<Integer> lt = new ArrayList<>();
        path(destination, lt);
        printPath(lt);
    }

    static void printPath(List<Integer> lt) {
        for(int i=0; i<lt.size(); i++){
            System.out.print(lt.get(i));
            if (i == lt.size() - 1) {
                System.out.println();
            } else{
                System.out.print(" -> ");
            }
        }
    }

    public int getLength(int destination){
        return order[destination];
    }
}

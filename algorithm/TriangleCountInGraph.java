package algorithm;

import java.util.ArrayList;
import java.util.List;
class Graph {
    private int V;
    private List<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public int countTriangles() {
        int count = 0;
        for (int i = 0; i < V; i++) {
            for (int j : adj[i]) {
                for (int k : adj[j]) {
                    if (adj[k].contains(i)) {
                        count++;
                    }
                }
            }
        }
        // Since each triangle is counted three times (one for each vertex),
        // divide by 3 to get the correct count.
        return count / 3;
    }
}
public class TriangleCountInGraph {
    public static void main(String[] args) {
        int V = 6; // Change this to the number of vertices in your graph
        Graph graph = new Graph(V);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);

        int numTriangles = graph.countTriangles();
        System.out.println("Number of triangles in the graph: " + numTriangles);
    }
}
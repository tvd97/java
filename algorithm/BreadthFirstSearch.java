package algorithm;

import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstSearch {
    // Số đỉnh
    private int V;
    // Mảng danh sách để biểu diễn danh sách kề
    private LinkedList linked[];

    public BreadthFirstSearch(int v) {
        V = v;
        linked = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            linked[i] = new LinkedList();
        }
    }

    // function thêm cạnh vào đồ thị
    void addEdge(int v, int k) {
        linked[v].add(k);
    }

    void BFS(int s) {
        // Đánh dấu tất cả các đỉnh là chưa được thăm (đặt là fasle mặc định trongjava)
        boolean visited[] = new boolean[V];
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList();
        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.println(s + " ");
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = linked[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }

        }
    }
    public static void main(String args[])
{


BreadthFirstSearch g = new BreadthFirstSearch(4);
g.addEdge(0, 1);
g.addEdge(0, 2);
g.addEdge(1, 2);
g.addEdge(2, 0);
g.addEdge(2, 3);
g.addEdge(3, 3);
System.out.println("Following is Breadth First Traversal "+

"(starting from vertex 2)");

g.BFS(2);
}
}

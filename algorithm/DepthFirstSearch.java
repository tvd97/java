package algorithm;

import java.util.*;
import java.io.*;

public class DepthFirstSearch {
    // Số đỉnh
    private int V;
    // Mảng danh sách để biểu diễn danh sách kề
    private LinkedList linked[];

    public DepthFirstSearch(int v) {
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

    void DFSUtil(int v, boolean visited[]) {
        // Đánh dấu nút hiện tại là đã truy cập và in ra
        visited[v] = true;
        System.out.println(v + " ");
        // Truy hồi cho tất cả các đỉnh kề với đỉnh này
        Iterator<Integer> i = linked[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    void DFS() {
        // Đánh dấu tất cả các đỉnh là chưa được thăm (đặt là fasle mặc định trongjava)
        boolean visited[] = new boolean[V];
        // Gọi hàm trợ giúp đệ quy để in DFS traversal bắt đầu từ tất cả các đỉnh một
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                DFSUtil(i, visited);
            }
        }
    }

    public static void main(String args[]) {
        DepthFirstSearch g = new DepthFirstSearch(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Following is Depth First Traversal");
        g.DFS();
    }
}

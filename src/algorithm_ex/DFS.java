package algorithm_ex;

import java.util.LinkedList;

public class DFS {
    private int V;
    private LinkedList<Integer> adjList[];
    
    DFS(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adjList[i] = new LinkedList();
    }
    
    
    public static void main(String args[]) {
        DFS g = new DFS(4);

        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);

        System.out.println("Depth First Traversal:");

        g.traverseDFS(2);
    }

    void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    void traverseDFS(int v) {
        boolean visited[] = new boolean[V];

        DFSUtil(v, visited);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        for (Integer neighbor : adjList[v]) {
            if (!visited[neighbor])
                DFSUtil(neighbor, visited);
        }
    }

}

/*
    Robert Higgins
    Professor Gardner
    Programming II
    2018-04-30

    Assignment: Depth-First and Breadth-First Search
    Implement either the depth-first or breath-first search algorithm to visit each vertex of the given graph.
 */
package Search;

import java.util.LinkedList;

public class Main {
    private static final int START = 1;
    private int V;
    private LinkedList<Integer>[] adj;

    private Main(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public static void main(String[] __args) {
        Main g = new Main(16);

        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 8);
        g.addEdge(4, 1);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(4, 9);
        g.addEdge(5, 4);
        g.addEdge(5, 6);
        g.addEdge(6, 5);
        g.addEdge(6, 7);
        g.addEdge(6, 10);
        g.addEdge(7, 6);
        g.addEdge(8, 3);
        g.addEdge(9, 4);
        g.addEdge(9, 11);
        g.addEdge(9, 12);
        g.addEdge(10, 6);
        g.addEdge(11, 9);
        g.addEdge(11, 13);
        g.addEdge(11, 14);
        g.addEdge(12, 9);
        g.addEdge(12, 15);
        g.addEdge(13, 11);
        g.addEdge(14, 11);
        g.addEdge(15, 12);

        System.out.println("Depth-first starting at " + START + ':');
        g.DFS();
    }

    private void addEdge(int __start, int __end) {
        adj[__start].add(__end);
    }

    private void DepthFirst(int __v, boolean[] __visited) {
        __visited[__v] = true;
        System.out.print(__v + " ");

        /* Recursion */
        for (Integer n : adj[__v]) {
            if (!__visited[n]) {
                DepthFirst(n, __visited);
            }
        }
    }

    private void DFS() {
        boolean[] visited = new boolean[V];
        DepthFirst(START, visited);
    }
}
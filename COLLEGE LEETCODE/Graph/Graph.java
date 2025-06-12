import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
    private static List<List<Integer>> adj;
    private static int size;

    public Graph() {
        adj = new ArrayList<>();
        size = 0;
    }

    private void addNode(int u) {
        adj.add(u, new ArrayList<>());
        size++;
    }

    private void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    private void print() {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println(i + " ->  " + adj.get(i));
        }
    }

    private void bfs() {
        boolean[] visited = new boolean[size];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int j = 0; j < adj.get(node).size(); j++) {
                int neighbor = adj.get(node).get(j);
                if (!visited[neighbor]) {
                    q.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of nodes: ");
            int n = sc.nextInt();

            System.out.print("Enter the nodes name: ");
            for (int i = 0; i < n; i++) {
                graph.addNode(sc.nextInt());
            }

            System.out.print("Enter the number of edges: ");
            int m = sc.nextInt();

            for (int i = 1; i <= m; i++) {
                System.out.print("Enter " + i + " edge: ");
                graph.addEdge(sc.nextInt(), sc.nextInt());
            }

            System.out.println("\nBFS traversal starting from node 0:");
            graph.bfs();

            graph.print();
        }
    }
}
// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class ShortestPathUndirectedGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 6;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(5);
        adj.get(5).add(4);

        int src = 0;
        ShortestPathUndirectedGraph solver = new ShortestPathUndirectedGraph();
        int[] dist = solver.shortestPath(adj, src);

        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Node " + i + ": " + dist[i]);
        }
    }

    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        dist[src] = 0;
        queue.offer(src);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    queue.offer(v);
                }
            }
        }
        return dist;
    }
}

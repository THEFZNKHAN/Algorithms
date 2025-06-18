import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TopologicalSort {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[] in = new int[V];
        for (int[] e : edges) {
            int from = e[0], to = e[1];
            adj.get(from).add(to);
            in[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            topo.add(u);

            for (int v : adj.get(u)) {
                in[v]--;
                if (in[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return topo;
    }
}
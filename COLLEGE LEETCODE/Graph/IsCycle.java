import java.util.ArrayList;
import java.util.List;

class IsCycle {
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int u, int p, boolean[] visited, List<List<Integer>> adj) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                if (dfs(v, u, visited, adj)) return true;
            } 
            else if (v != p) return true;
        }
        return false;
    }
}

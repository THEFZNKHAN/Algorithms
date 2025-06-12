import java.util.Queue;
import java.util.LinkedList;

public class FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int ctr1 = 0, ctr2 = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(isConnected, visited, i);
                ctr1++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                ctr2++;
            }
        }

        return ctr1;
    }

    private void bfs(int[][] graph, boolean[] visited, int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int j = 0; j < visited.length; j++) {
                if (graph[node][j] == 1 && !visited[j]) {
                    q.add(j);
                    visited[j] = true;
                }
            }
        }
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[city][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }
}
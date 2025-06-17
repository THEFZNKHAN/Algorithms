import java.io.*;
import java.util.*;

public class BuildingRoads {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 20);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];
        List<Integer> list = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                list.add(i);
                visited[i] = true;

                queue.offer(i);
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    for (int v : adj.get(u)) {
                        if (!visited[v]) {
                            visited[v] = true;
                            queue.offer(v);
                        }
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 20);
        int k = list.size() - 1;

        bw.write(Integer.toString(k));
        bw.newLine();

        for (int i = 0; i < k; i++) {
            bw.write(list.get(i) + " " + list.get(i + 1));
            bw.newLine();
        }
        bw.flush();
    }
}

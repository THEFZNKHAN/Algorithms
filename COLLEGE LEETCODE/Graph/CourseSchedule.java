import java.util.*;

class CourseSchedule {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] in = new int[n];
        for (int[] p : pre) {
            adj.get(p[1]).add(p[0]);
            in[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) q.offer(i);
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            cnt++;

            for (int next : adj.get(u)) {
                in[next]--;
                if (in[next] == 0) q.offer(next);
            }
        }

        return cnt == n;
    }
}

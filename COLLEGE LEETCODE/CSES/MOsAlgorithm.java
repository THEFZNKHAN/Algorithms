import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MOsAlgorithm {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[] arr = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            StringBuilder sb = new StringBuilder();
            for (int qi = 0; qi < m; qi++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;
                long ans = MOsAlgorithm(arr, n, l, r);
                sb.append(ans).append('\n');
            }
            System.out.print(sb);
        }
    }

    private static long MOsAlgorithm(long[] arr, int n, int l, int r) {
        int root = (int) Math.sqrt(n);
        if (root == 0) root = 1;
        int len = (n + root - 1) / root;

        long[] pre = new long[len];
        for (int i = 0; i < n; i++) {
            pre[i / root] += arr[i];
        }

        long sum = 0;
        int s = l / root;
        int e = r / root;

        if (s == e) {
            for (int i = l; i <= r; i++) sum += arr[i];
        } else {
            for (int i = l; i < (s + 1) * root; i++) sum += arr[i];
            for (int b = s + 1; b < e; b++) sum += pre[b];
            for (int i = e * root; i <= r; i++) sum += arr[i];
        }

        return sum;
    }
}

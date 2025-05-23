import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StaticRangeSumQueries {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            long[] pre = new long[n];
            pre[0] = Long.parseLong(st.nextToken());
            for (int i = 1; i < n; i++) {
                pre[i] = pre[i - 1] + Long.parseLong(st.nextToken());
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                String line = br.readLine();
                int idx = line.indexOf(' ');
                int a = Integer.parseInt(line.substring(0, idx));
                int b = Integer.parseInt(line.substring(idx + 1));

                if (a == 1) sb.append(pre[b - 1]).append('\n');
                else sb.append(pre[b - 1] - pre[a - 2]).append('\n');
            }
            System.out.print(sb.toString());
        }
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class StaticRangeMinQueries {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] seg = new int[4*n];
        build(0, n - 1, 0, arr, seg);

        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            sb.append(min(0, 0, n - 1, l, r, arr, seg)).append("\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }

    private static void build(int s, int e, int i, int[] arr, int[] seg) {
        if (s == e) {
            seg[i] = arr[s];
        } else {
            int mid = s + (e - s) / 2;
            build(s, mid, 2 * i + 1, arr, seg);
            build(mid + 1, e, 2 * i + 2, arr, seg);
            seg[i] = Math.min(seg[2 * i + 1], seg[2 * i + 2]);
        }
    }

    private static int min(int i, int low, int high, int l, int r, int[] arr, int[] seg) {
        if (l <= low && high <= r) return seg[i];
        if (high < l || low > r) return Integer.MAX_VALUE;
        int mid = low + (high - low) / 2;

        int left = min(2 * i + 1, low, mid, l, r, arr, seg);
        int right = min(2 * i + 2, mid + 1, high, l, r, arr, seg);
        return Math.min(left, right);
    }
}

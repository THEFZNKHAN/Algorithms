import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class DynamicRangeMinQueries {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] seg = new int[4 * n];
        build(0, 0, n - 1, arr, seg);

        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if ("1".equals(t)) {
                update(0, 0, n - 1, a - 1, b, seg);
            } else {
                sb.append(query(0, a - 1, b - 1, 0, n - 1, seg)).append("\n");
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        
    }

    private static void build(int idx, int l, int r, int[] arr, int[] seg) {
        if (l == r) {
            seg[idx] = arr[l];
        } else {
            int mid = l + (r - l) / 2;
            build(2 * idx + 1, l, mid, arr, seg);
            build(2 * idx + 2, mid + 1, r, arr, seg);
            seg[idx] = Math.min(seg[2 * idx + 1], seg[2 * idx + 2]);
        }
    }

    private static void update(int idx, int l, int r, int pos, int val, int[] seg) {
        if (l == r) {
            seg[idx] = val;
        } else {
            int mid = l + (r - l) / 2;
            if (pos <= mid) update(2 * idx + 1, l, mid, pos, val, seg);
            else update(2 * idx + 2, mid + 1, r, pos, val, seg);
            seg[idx] = Math.min(seg[2 * idx + 1], seg[2 * idx + 2]);
        }
    }

    private static int query(int idx, int l, int r, int low, int high, int[] seg) {
        if (l <= low && high <= r) return seg[idx];
        if (l > high || r < low) return Integer.MAX_VALUE;
        int mid = low + (high - low) / 2;
        int left = query(2 * idx + 1, l, r, low, mid, seg);
        int right = query(2 * idx + 2, l, r, mid + 1, high, seg);
        return Math.min(left, right);
    }
}

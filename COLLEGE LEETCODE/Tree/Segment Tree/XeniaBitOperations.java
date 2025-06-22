// https://codeforces.com/problemset/problem/339/D

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class XeniaBitOperations {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int len = (1 << n);
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        int[] seg = new int[4 * len];
        build(0, 0, len - 1, arr, seg, (n & 1) == 1);

        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());
            update(0, 0, len - 1, p, b, seg, (n & 1) == 1);
            sb.append(seg[0]).append("\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }

    private static void build (int idx, int l , int r, int[] arr, int[] seg, boolean or) {
        if (l == r) {
            seg[idx] = arr[l];
            return;
        }
        int  mid = l + (r - l) / 2;
        build(2 * idx + 1, l, mid, arr, seg, !or);
        build(2 * idx + 2, mid + 1, r, arr, seg, !or);

        if (or) seg[idx] = seg[2 * idx + 1] | seg[2 * idx + 2];
        else seg[idx] = seg[2 * idx + 1] ^ seg[2 * idx + 2];
    }

    private static void update(int idx, int l, int r, int p, int b, int[] seg, boolean or) {
        if (l == r) {
            seg[idx] = b;
            return;
        }

        int mid = l + (r - l) / 2;
        if (p <= mid) update(2 * idx + 1, l, mid, p, b, seg, !or);
        else update(2 * idx + 2, mid + 1, r, p, b, seg, !or);

        if (or) seg[idx] = seg[2 * idx + 1] | seg[2 * idx + 2];
        else seg[idx] = seg[2 * idx + 1] ^ seg[2 * idx + 2];
    }
}

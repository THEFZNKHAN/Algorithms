public class Max {
    private static int[] arr;
    private static int[] seg;

    public static void main(String[] args) {
        int n = 6;
        arr = new int[n];
        seg = new int[4 *  n];
        arr = new int[] { 1, 3, 5, 7, 9, 11 };
        build(0, n - 1, 0);
        System.out.println("Max in range [1, 4]: " + max(0, 0, n - 1, 1, 4));
        System.out.println("Max in range [2, 5]: " + max(0, 0, n - 1, 2, 5));
        update(0, 0, n - 1, 1, 4);
        System.out.println("Max in range [1, 4]: " + max(0, 0, n - 1, 0, 3));
        System.out.println("Max in range [2, 5]: " + max(0, 0, n - 1, 2, 5));
    }

    private static void build(int s, int e, int i) {
        if (s == e) {
            seg[i] = arr[s];
        } else {
            int mid = s + (e - s) / 2;
            build(s, mid, 2 * i + 1);
            build(mid + 1, e, 2 * i + 2);
            seg[i] = Math.max(seg[2 * i + 1], seg[2 * i + 2]);
        }
    }

    private static int max(int i, int low, int high, int l, int r) {
        if (l <= low && high <= r) return seg[i];
        if (high < l || low > r) return Integer.MIN_VALUE;
        int mid = low + (high - low) / 2;

        int left = max(2 * i + 1, low, mid, l, r);
        int right = max(2 * i + 2, mid + 1, high, l, r);
        return Math.max(left, right);
    }

    private static void update(int node, int low, int high, int pos, int val) {
        if (low == high) {
            seg[node] = val;
        } else {
            int mid = low + (high - low) / 2;
            if (pos <= mid) update(2 * node + 1, low, mid, pos, val);
            else update(2 * node + 2, mid + 1, high, pos, val);
            seg[node] = Math.max(seg[2 * node + 1], seg[2 * node + 2]);
        }
    }
}

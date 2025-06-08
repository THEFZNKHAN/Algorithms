public class Max {
    private static int[] arr;
    private static int[] seg;

    public Max(int n) {
        arr = new int[n];
        seg = new int[4 * n];
    }

    public static void main(String[] args) {
        int n = 6;
        Max tree = new Max(n);
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

    private static void update(int idx, int low, int high, int i, int nv) {
        if (low == high) {
            arr[i] = nv;
            seg[idx] = nv;
        } else {
            int mid = low + (high - low) / 2;
            if (i >= low && i <= mid) {
                update(2 * idx + 1, low, mid, i, nv);
            } else {
                update(2 * idx + 2, mid + 1, high, i, nv);
            }
            seg[idx] = Math.max(seg[2 * idx + 1], seg[2 * idx + 2]);
        }
    }
}
class RangeMinMaxQueries {
    public int[] getMinMax(int[] arr, int L, int R, int[][] segTree) {
        return getHelper(arr, 0, arr.length - 1, L, R, 0, segTree);
    }

    private int[] getHelper(int[] arr, int low, int high, int L, int R, int idx, int[][] segTree) {
        if (R < low || L > high) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
        }
        if (L <= low && high <= R) return segTree[idx];

        int mid = low + (high - low) / 2;
        int[] left = getHelper(arr, low, mid, L, R, 2 * idx + 1, segTree);
        int[] right = getHelper(arr, mid + 1, high, L, R, 2 * idx + 2, segTree);
        return new int[] {
            Math.min(left[0], right[0]),
            Math.max(left[1], right[1])
        };
    }

    public void updateValue(int[] arr, int index, int value, int[][] segTree) {
        updateHelper(arr, 0, arr.length - 1, index, value, 0, segTree);
    }

    private void updateHelper(int[] arr, int low, int high, int pos, int value, int idx, int[][] segTree) {
        if (low == high) {
            arr[pos] = value;
            segTree[idx][0] = value;
            segTree[idx][1] = value;
        } else {
            int mid = low + (high - low) / 2;
            if (pos <= mid) {
                updateHelper(arr, low, mid, pos, value, 2 * idx + 1, segTree);
            } else {
                updateHelper(arr, mid + 1, high, pos, value, 2 * idx + 2, segTree);
            }
            int[] left = segTree[2 * idx + 1];
            int[] right = segTree[2 * idx + 2];
            segTree[idx][0] = Math.min(left[0], right[0]);
            segTree[idx][1] = Math.max(left[1], right[1]);
        }
    }
}

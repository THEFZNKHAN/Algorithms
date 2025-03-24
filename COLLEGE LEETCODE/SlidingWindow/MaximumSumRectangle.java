class MaximumSumRectangle {
    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, -1, -4, -20},
            {-8, -3, 4, 2, 1},
            {3, 8, 10, 1, 3},
            {-4, -1, 1, 7, -6}
        };
        int result = maximumSumRectangle(mat);
        System.out.println("Maximum Sum Rectangle: " + result);
    }

    public static int maximumSumRectangle(int mat[][]) {
        int m = mat.length, n = mat[0].length;
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            int[] temp = new int[n];
            for (int i = j; i < m; i++) {
                sum(temp, mat[i], n);
                int val = kadane(temp);
                if (val > max) max = val;
            }
        }
        return max;
    }

    private static int kadane(int[] arr) {
        int curr = 0, max = arr[0];
        for (int n : arr) {
            curr += n;
            if (curr > max) max = curr;
            if (curr < 0) curr = 0;
        }
        return max;
    }

    private static void sum(int[] a, int[] b, int n) {
        for (int i = 0; i < n; i++) a[i] += b[i];
    }
}

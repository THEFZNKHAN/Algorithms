class MinRecScore {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 2, 3},
            {4, 2, 2, 3},
            {4, 4, 4, 4},
            {5, 5, 5, 5}
        };
        int result = maximumRectangleScore(arr);
        System.out.println("Maximum Rectangle Score: " + result);
    }

    public static int maximumRectangleScore(int[][] arr) {
        int n = arr.length;
        if (n < 2) return 0;
        int m = arr[0].length;
        if (m < 2) return 0;

        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                int curr = arr[i][j];
                if (arr[i][j + 1] == curr && arr[i + 1][j] == curr && arr[i + 1][j + 1] == curr) {
                    if (curr > max) max = curr;
                }
            }
        }
        return max;
    }
}
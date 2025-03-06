
class MatrixBlockSum {

    public static void main(String[] args) {
        MatrixBlockSum obj = new MatrixBlockSum();
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int K = 1;
        int[][] result = obj.matrixBlockSum(mat, K);
        for (int[] result1 : result) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result1[j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] prefixSum = new int[m + 1][n + 1];
        int[][] result = new int[m][n];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = mat[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            int r1 = Math.max(0, i - K), r2 = Math.min(m, i + K + 1);
            for (int j = 0; j < n; j++) {
                int c1 = Math.max(0, j - K), c2 = Math.min(n, j + K + 1);
                result[i][j] = prefixSum[r2][c2] - prefixSum[r1][c2] - prefixSum[r2][c1] + prefixSum[r1][c1];
            }
        }

        return result;
    }

    // BRUTE FORCE
    public int[][] matrixBlockSum2(int[][] mat, int k) {
        int row = mat.length, col = mat[0].length;
        int[][] answer = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int sum = 0;
                for (int a = i - k; a <= i + k; a++) {
                    for (int b = j - k; b <= j + k; b++) {
                        if (a < 0 || a >= row || b < 0 || b >= col) {
                            continue;
                        }
                        sum += mat[a][b];
                    }
                }
                answer[i][j] = sum;
            }
        }

        return answer;
    }
}

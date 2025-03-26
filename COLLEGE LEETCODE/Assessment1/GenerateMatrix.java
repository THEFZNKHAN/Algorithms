import java.util.Arrays;

public class GenerateMatrix {
    public static void main(String[] args) {
        int[] rowSum = { 5, 7, 10 };
        int[] colSum = { 8, 6, 8 };

        GenerateMatrix gm = new GenerateMatrix();
        int[][] result = gm.generateMatrix(rowSum, colSum);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int[][] generateMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length, m = colSum.length;
        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = Math.min(rowSum[i], colSum[j]);
                mat[i][j] = val;
                rowSum[i] -= val;
                colSum[j] -= val;
            }
        }

        return mat;
    }
}

import java.util.Arrays;

public class RotateEachRowMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        int k = 2;

        System.out.println("Original Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        int[][] rotatedMatrix = rotateMatrix(k, matrix);

        System.out.println("\nRotated Matrix:");
        for (int[] row : rotatedMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] rotateMatrix(int k, int[][] mat) {
        int rows = mat.length;
        int[][] result = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int[] row = mat[i];
            int m = row.length;
            int effectiveK = k % m;

            if (effectiveK == 0) {
                result[i] = Arrays.copyOf(row, m);
                continue;
            }

            int[] rotatedRow = new int[m];
            System.arraycopy(row, effectiveK, rotatedRow, 0, m - effectiveK);
            System.arraycopy(row, 0, rotatedRow, m - effectiveK, effectiveK);
            result[i] = rotatedRow;
        }

        return result;
    }
}

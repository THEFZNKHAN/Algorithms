public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        rotate180(matrix);

        System.out.println("Matrix after 180 degree rotation:");
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();

        }
    }

    public static void rotate(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }
    }

    public static void rotate180(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[n - 1 - i][n - 1 - j];
                mat[n - 1 - i][n - 1 - j] = temp;
            }
        }
        if (n % 2 != 0) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[n / 2][j];
                mat[n / 2][j] = mat[n / 2][n - 1 - j];
                mat[n / 2][n - 1 - j] = temp;
            }
        }
    }

}

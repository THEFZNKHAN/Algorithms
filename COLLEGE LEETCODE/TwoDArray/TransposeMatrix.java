import java.util.Scanner;

public class TransposeMatrix {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of rows and columns: ");
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();

            int[][] mat = new int[rows][cols];
            System.out.print("Enter the elements of the matrix: ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    mat[i][j] = scanner.nextInt();
                }
            }

            int[][] ans = transpose(mat);
            System.out.println("Transposed matrix:");
            for (int[] a : ans) {
                for (int i : a) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }

    public static int[][] transpose(int[][] mat) {
        int r = mat[0].length, c = mat.length;
        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = mat[j][i];
            }
        }
        return ans;
    }
}

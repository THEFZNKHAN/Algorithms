import java.util.Arrays;
import java.util.Scanner;

public class ReshapeMatrix {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the row size of the array: ");
            int m = sc.nextInt();
            System.out.print("Enter the column size of the array: ");
            int n = sc.nextInt();
            int[][] nums = new int[m][n];

            for (int i = 0; i < m; i++) {
                System.out.print("Enter the elements of the " + i + "th row: ");
                for (int j = 0; j < n; j++)
                    nums[i][j] = sc.nextInt();
            }

            System.out.print("Enter the row size of the new array: ");
            int r = sc.nextInt();
            System.out.print("Enter the column size of the new array: ");
            int c = sc.nextInt();
            int[][] ans = matrixReshape(nums, r, c);
            for (int[] a : ans)
                System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] ans = new int[r][c];
        int a = 0, b = 0, mc = mat[0].length, mr = mat.length;
        if (mr * mc != r * c) return mat;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = mat[a][b];
                b++;
                if (b == mc) {
                    b = 0;
                    a++;
                }
            }
        }
        return ans;
    }
}

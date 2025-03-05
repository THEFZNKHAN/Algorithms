import java.util.Arrays;
import java.util.Scanner;

public class Construct2DArray {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter the size of the array: ");
            int n = sc.nextInt();
            int[] nums = new int[n];

            System.out.print("Enter the elements of the arrays: ");
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            System.out.print("Number of rows in the newly converted 2D array: ");
            int r = sc.nextInt();
            System.out.print("Number of columns in the newly converted 2D array: ");
            int c = sc.nextInt();
            int[][] ans = construct2DArray(nums, r, c);
            for (int[] a : ans) {
                System.out.println(Arrays.toString(a));
            }
        }
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) return new int[0][0];
        int[][] arr = new int[m][];
        for (int i = 0; i < m; i++) {
            arr[i] = Arrays.copyOfRange(original, i * n, i * n + n);
        }
        return arr;
    }
}

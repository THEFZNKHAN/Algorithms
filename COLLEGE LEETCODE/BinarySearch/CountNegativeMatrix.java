import java.util.Scanner;

class CountNegativeMatrix {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of rows: ");
            int rows = scanner.nextInt();
            System.out.print("Enter the number of columns: ");
            int cols = scanner.nextInt();
            int[][] grid = new int[rows][cols];

            System.out.print("Enter the elements of the matrix: ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }

            int result = countNegatives(grid);
            System.out.println("The number of negative numbers in the matrix is: " + result);
        }
    }

    private static int countNegatives(int[][] grid) {
        int sum = 0;
        for (int[] g : grid) sum += helper(g);
        return sum;
    }

    private static int helper(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < 0) r = mid - 1; 
            else l = mid + 1;
        }
        return n - l;
    }
}

public class MatrixSearch {
    public static void main(String[] args) {
        int[][] mat = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;
        int[] result = search(mat, target);
        System.out.println("Target found at: [" + result[0] + ", " + result[1] + "]");

        boolean found = binarySearch(mat, target);
        System.out.println("Target found using binary search: " + found);
    }

    private static int[] search(int[][] mat, int t) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == t) return new int[]{ i, j };
            }
        }
        return new int[]{ -1, -1 };
    }

    private static boolean binarySearch(int[][] mat, int t) {
        int rows = mat.length;
        int cols = mat[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = mat[mid / cols][mid % cols];

            if (midValue == t) {
                return true;
            } else if (midValue < t) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

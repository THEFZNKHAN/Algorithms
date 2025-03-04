// https://leetcode.com/problems/range-sum-query-2d-immutable/

public class RangeSumQuery2D {
    int[][] nums;

    public RangeSumQuery2D(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        nums = new int[n][m];
        nums[0][0] = matrix[0][0];

        for (int j = 1; j < m; j++) {
            nums[0][j] = nums[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            nums[i][0] = nums[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < n; i++) {
            int rowSum = matrix[i][0];
            for (int j = 1; j < m; j++) {
                rowSum += matrix[i][j];
                nums[i][j] = nums[i - 1][j] + rowSum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = nums[row2][col2];
        int extraAbove = (row1 > 0) ? nums[row1 - 1][col2] : 0;
        int extraLeft = (col1 > 0) ? nums[row2][col1 - 1] : 0;
        int addBack = (row1 > 0 && col1 > 0) ? nums[row1 - 1][col1 - 1] : 0;
        return total - extraAbove - extraLeft + addBack;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };
        RangeSumQuery2D obj = new RangeSumQuery2D(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(1, 1, 2, 2));
        System.out.println(obj.sumRegion(1, 2, 2, 4));
    }
}

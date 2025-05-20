import java.util.Arrays;

class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = new int[]{ 2, 1, 3, 4 };
        System.out.println(matrixMultiplication(arr));
        System.out.println(matrixMultiplication_Tab(arr));
    }

    private static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int[] d : dp) Arrays.fill(d, -1);
        return helper(1, n - 1, arr, dp);
    }
    
    private static int helper (int i, int j, int[] arr, int[][] dp) {
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        
        int min = (int) 1e9;
        for (int k = i; k < j; k++) {
            int res = helper(i, k, arr, dp) + 
                helper(k + 1, j, arr, dp) + (arr[i - 1] * arr[k] * arr[j]);
            min = Math.min(min, res);
        }
        return dp[i][j] = min;
    }

    static int matrixMultiplication_Tab(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        
        for (int i = n - 1; i > 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + (arr[i - 1] * arr[k] * arr[j]));
                }
            }
        }
        return dp[1][n - 1];
    }
}

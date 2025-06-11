import java.util.Arrays;
import java.util.Scanner;

public class JobWorker {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            int[][] dp = new int[n][1 << n];
            for (int[] d : dp) Arrays.fill(d, -1);
            int ans = helper(0, 0, n, mat, dp);
            System.out.println(ans);
        }
    }

    private static int helper(int i, int mask, int n, int[][] cost, int[][] dp) {
        if (i == n) return 0;
        if (dp[i][mask] != -1) return dp[i][mask];

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if ((mask & (1 << j)) == 0) {
                min = Math.min(min, cost[i][j] + helper(i + 1, mask | (1 << j), n, cost, dp));
            }
        }

        return dp[i][mask] = min;
    }
}

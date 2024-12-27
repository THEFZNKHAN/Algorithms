import java.util.Arrays;

class UnboundedKnapsack {
    public static void main(String args[]) {
        int wt[] = { 2, 4, 6 };
        int val[] = { 5, 11, 13 };
        int W = 11;

        int n = wt.length;

        // Call the unboundedKnapsack function and print the result
        System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsackM(n, W, val, wt));
        System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsackT(n, W, val, wt));
        System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsackS(n, W, val, wt));
    }

    // USING MEMOIZATION
    private static int unboundedKnapsackM(int n, int W, int[] val, int[] wt) {
        int[][] dp = new int[n + 1][W + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return helper(n - 1, W, val, wt, dp);
    }

    private static int helper(int n, int W, int[] val, int[] wt, int[][] dp) {
        if (n == 0)
            return (int) (W / wt[0]) * val[0];
        if (dp[n][W] != -1)
            return dp[n][W];
        int skip = helper(n - 1, W, val, wt, dp);
        int taken = W >= wt[n] ? val[n] + helper(n, W - wt[n], val, wt, dp) : 0;
        return dp[n][W] = Math.max(skip, taken);
    }

    // USING TABULATION
    private static int unboundedKnapsackT(int n, int W, int[] val, int[] wt) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (wt[i - 1] <= j)
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][W];
    }

    // USING SPACE OPTIMIZED TABULATION
    private static int unboundedKnapsackS(int n, int W, int[] val, int[] wt) {
        int dp[] = new int[W + 1];

        for (int i = wt[0]; i <= W; i++) {
            dp[i] = ((int) i / wt[0]) * val[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                int notTaken = dp[j];
                int taken = wt[i] <= j ? val[i] + dp[j - wt[i]] : 0;
                dp[j] = Math.max(notTaken, taken);
            }
        }

        return dp[W];
    }
}
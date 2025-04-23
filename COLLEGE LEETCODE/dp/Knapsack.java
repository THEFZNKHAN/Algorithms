class Knapsack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        int maxProfit = knapsack(W, val, wt);
        System.out.println("Maximum profit: " + maxProfit);
        System.out.println("Maximum profit: " + tab(W, val, wt));
        System.out.println("Maximum profit: " + space_opt(W, val, wt));
    }

    // SPACE OPTIMIZED
    private static int space_opt(int W, int[] val, int[] wt) {
        int n = val.length;
        int[] prev = new int[W + 1];
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[W + 1];
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) curr[j] = val[i - 1] + prev[j - wt[i- 1]];
                curr[j] = Math.max(curr[j], prev[j]);
            }
            prev = curr.clone();
        }
        return prev[W];
    }

    // TABULATION
    private static int tab(int W, int[] val, int[] wt) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) dp[i][j] = val[i - 1] + dp[i - 1][j - wt[i- 1]];
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }
        }
        return dp[n][W];
    }

    // Memoization
    private static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) dp[i][j] = -1;
        }
        return memo(val, n, wt, W, dp);
    }
    
    private static int memo(int[] val, int n, int[] wt, int W, int[][] dp) {
        if (n == 0 || W == 0) return 0;
        if (dp[n][W] != -1) return dp[n][W];
        int pick = 0;
        if (wt[n - 1] <= W) {
            pick = val[n - 1] + memo(val, n - 1, wt, W - wt[n - 1], dp);
        }
        int skip = memo(val, n - 1, wt, W, dp);
        return dp[n][W] = Math.max(pick, skip);
    }

}
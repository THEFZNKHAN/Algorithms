class CuttingRod {
    public int cuttingRod(int[] price) {
        int n = price.length;
        int[] wt = new int[n];
        for (int i = 1; i <= n; i++) {
            wt[i - 1] = i;
        }
        return unboundedKnapsack(n, price, wt);
    }

    private static int unboundedKnapsack(int W, int[] val, int[] wt) {
        int[] dp = new int[W + 1];
        for (int i = 0; i < val.length; i++) {
            for (int w = wt[i]; w <= W; w++) {
                dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
            }
        }
        return dp[W];
    }
}

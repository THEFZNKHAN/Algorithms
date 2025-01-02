import java.util.Arrays;

public class BuySellFee {
    public static void main(String[] args) {
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        int fee = 2;

        System.out.println("Max Profit (Memoization): " + maxProfitM(prices, fee));
        System.out.println("Max Profit (Tabulation): " + maxProfitT(prices, fee));
        System.out.println("Max Profit (Optimized): " + maxProfitS(prices, fee));
    }

    // *** MEMOIZATION SOLUTION ***
    public static int maxProfitM(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int[] d : dp) Arrays.fill(d, -1);
        return memo(0, 1, fee, prices, dp, n);
    }

    private static int memo(int i, int buy, int fee, int[] prices, int[][] dp, int n) {
        if (i >= n) return 0;
        if (dp[i][buy] != -1) return dp[i][buy];

        if (buy == 1) return dp[i][buy] = Math.max(-prices[i] + memo(i + 1, 0, fee, prices, dp, n), memo(i + 1, 1, fee, prices, dp, n));
        return dp[i][buy] = Math.max(prices[i] - fee + memo(i + 1, 1, fee, prices, dp, n), memo(i + 1, 0, fee, prices, dp, n));
    }

    // *** TABULATION SOLUTION ***
    private static int maxProfitT(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j == 1) dp[i][j] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
                else dp[i][j] = Math.max(prices[i] - fee + dp[i + 1][1], dp[i + 1][0]);
            }
        }
        return dp[0][1];
    }

    // *** OPTIMIZED SOLUTION ***
    private static int maxProfitS(int[] prices, int fee) {
        int n = prices.length;
        int profit = 0, buy = -prices[0];

        for (int i = 1; i < n; i++) {
            int tmp = buy;
            buy = Math.max(buy, profit - prices[i]);
            profit = Math.max(profit, tmp + prices[i] - fee);
        }
        return profit;
    }
}

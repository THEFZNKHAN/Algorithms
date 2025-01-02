import java.util.Arrays;

class SellStockIV {
    public static void main(String[] args) {
        int[] prices = new int[] { 1, 2, 3, 0, 2 };
        System.out.println(maxProfitM(prices));
        System.out.println(maxProfitT(prices));
        System.out.println(maxProfit(prices));
    }

    // *** MEMOIZATION SOLUTION ***
    public static int maxProfitM(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] d : dp) Arrays.fill(d, -1);
        return memo(0, 1, prices, dp, n);
    }

    private static int memo(int i, int buy, int[] prices, int[][] dp, int n) {
        if (i >= n) return 0;
        if (dp[i][buy] != -1) return dp[i][buy];
        if (buy == 1) 
            return dp[i][buy] = Math.max(-prices[i] + memo(i + 1, 0, prices, dp, n), memo(i + 1, 1, prices, dp, n));
        return dp[i][buy] = Math.max(prices[i] + memo(i + 2, 1, prices, dp, n), memo(i + 1, 0, prices, dp, n));
    }

    // *** TABULATION SOLUTION ***
    public static int maxProfitT(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j == 1) {
                    dp[i][j] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
                } else {
                    dp[i][j] = Math.max(prices[i] + dp[i + 2][1], dp[i + 1][0]);
                }
            }
        }
        return dp[0][1];
    }

    // *** OPTIMIZED SOLUTION ***
    public static int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;
        for (int price : prices) {
            int preSold = sold;
            sold = held + price;
            held = Math.max(held, reset - price);
            reset = Math.max(reset, preSold);
        }
        return Math.max(sold, reset);
    }
}
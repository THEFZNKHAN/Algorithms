import java.util.Arrays;

public class SellStockIII {
    public static void main(String[] args) {
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int k = 2;
        System.out.println(maxProfitM(prices, k));
        System.out.println(maxProfitT(prices, k));
        System.out.println(maxProfitS(prices));
    }

    // USING MEMOIZATION (Time Complexity: O(n*k*2), Space Complexity: O(n*k*2))
    private static int maxProfitM(int[] prices, int k) {
        int n = prices.length;
        int[][][] memo = new int[n][k + 1][2];
        for (int[][] arr2D : memo) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }
        return helper(0, k, 1, prices, memo, n);
    }

    private static int helper(int i, int k, int buy, int[] prices, int[][][] memo, int n) {
        if (k == 0)
            return 0;
        if (i >= n)
            return 0;
        if (memo[i][k][buy] != -1)
            return memo[i][k][buy];

        if (buy == 1) {
            memo[i][k][buy] = Math.max(-prices[i] + helper(i + 1, k, 0, prices, memo, n),
                    helper(i + 1, k, 1, prices, memo, n));
        } else {
            memo[i][k][buy] = Math.max(prices[i] + helper(i + 1, k - 1, 1, prices, memo, n),
                    helper(i + 1, k, 0, prices, memo, n));
        }

        return memo[i][k][buy];
    }

    // USING TABULATION (Time Complexity: O(n*k*2), Space Complexity: O(n*k*2))
    private static int maxProfitT(int[] prices, int k) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][k + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                for (int buy = 0; buy <= 1; buy++) {
                    if (buy == 1) {
                        dp[i][j][buy] = Math.max(-prices[i] + dp[i + 1][j][0], dp[i + 1][j][1]);
                    } else {
                        dp[i][j][buy] = Math.max(prices[i] + dp[i + 1][j - 1][1], dp[i + 1][j][0]);

                    }
                }
            }
        }

        return dp[0][k][1];
    }

    // SPACE OPTIMIZED
    public static int maxProfitS(int[] prices) {
        int firstBuy = Integer.MAX_VALUE, secondBuy = Integer.MAX_VALUE;
        int firstSell = 0, secondSell = 0;

        for (int price : prices) {
            firstBuy = Math.min(firstBuy, price);
            firstSell = Math.max(firstSell, price - firstBuy);
            secondBuy = Math.min(secondBuy, price - firstSell);
            secondSell = Math.max(secondSell, price - secondBuy);
        }

        return secondSell;
    }
}

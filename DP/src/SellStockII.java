// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

public class SellStockII {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int min = prices[0], ans = 0;
        for (int p : prices) {
            if (p - min > 0) {
                ans += p - min;
                min = p;
                continue;
            }
            min = Math.min(min, p);
        }
        return ans;
    }
}

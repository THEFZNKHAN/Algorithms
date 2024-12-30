// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class SellStock {
    public static void main(String[] args) {
        SellStock sellStock = new SellStock();
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(sellStock.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }

        return maxProfit;
    }
}
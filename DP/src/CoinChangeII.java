public class CoinChangeII {
    public static void main(String[] args) {
        int amt = 5;
        int[] coins = { 1, 2, 5 };
        int result = change(amt, coins);
        System.out.println("Number of ways to make change: " + result);
    }

    public static int change(int amt, int[] coins) {
        int[] dp = new int[amt + 1];
        dp[0] = 1;
        for (int c : coins) {
            for (int j = c; j <= amt; j++) {
                dp[j] += dp[j - c];
            }
        }
        return dp[amt];
    }
}

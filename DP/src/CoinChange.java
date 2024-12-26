
import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        int result = coinChange(coins, amount);
        System.out.println("Minimum coins needed: " + result);
    }

    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

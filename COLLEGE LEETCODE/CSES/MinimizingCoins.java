
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MinimizingCoins {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] in = br.readLine().split(" ");
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]);
            int t = Integer.parseInt(in[1]);

            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);

            int[] dp = new int[t + 1];

            int ans = helper(arr, t, n, dp);
            System.out.println(ans);
        }
    }

    private static int helper_memo(int[] coins, int t, int[] dp, int n) {
        if (t == 0) return 0;
        if (dp[t] != 0)  return dp[t];
        int val = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (coins[i] > t) continue;
            val = Math.min(helper_memo(coins, t - coins[i], dp, n) + 1, val);
        }
        return dp[t] = val;
    }

    private static int helper(int[] coins, int t, int n, int[] dp) {
        for (int i = 1; i <= t; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[t] == Integer.MAX_VALUE ? -1 : dp[t];
    }

}
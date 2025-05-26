import java.util.Arrays;

class TilingWithDominoes {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        for (int i = 0; i < 11; i+=2) {
            int[] dp = new int[i +1];
            Arrays.fill(dp, -1);
            System.out.print("Memoization: " + memo(i, dp));
            System.out.println(" | Tabulation: " + tab(i));
        }
    }

    private static int memo(int n, int[] dp) {
        if (n == 0) return 1;
        if (n == 2) return 3;
        if ((n & 1) == 1) return 0;
        if (dp[n] != -1) return dp[n];
        return dp[n] = (4 * memo(n - 2, dp) - memo(n - 4, dp)) % MOD;
    }

    private static int tab(int n) {
        if ((n & 1) == 1) return 0;
        if (n == 0) return 1;
        if (n == 2) return 3;

        int[] dp = new int[n + 1];
        dp[0] = 1; dp[2] = 3;
        for (int i = 4; i <= n; i+=2) {
            dp[i] = (4 * dp[i - 2] - dp[i - 4]) % MOD;
            if (dp[i] < 0) dp[i] += MOD;
        }
        return dp[n];
    }
}
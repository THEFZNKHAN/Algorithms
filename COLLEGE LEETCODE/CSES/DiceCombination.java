import java.util.Scanner;

class DiceCombination {
    private static final int M = 1_000_000_007;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner((System.in))) {
            int n = sc.nextInt();
            long[] dp = new long[n + 1];
            dp[0] = 1;
            long ans = dice(n, dp);
            System.out.println(ans % M);
        }
    }

    private static long dice(int n, long[] dp) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                if (j > i) break;
                dp[i] = (dp[i] + dp[i - j]) % M;
            }
        }
        return dp[n];
    }
}
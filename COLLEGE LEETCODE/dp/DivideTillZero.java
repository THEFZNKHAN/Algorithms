import java.util.Arrays;

class DivideTillZero {
    private static int[] dp;
    private static int ctr = 0;

    public static void main(String[] args) {
        int n = 1000;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(helper(n));
        System.out.println("No. of calls: " + ctr);

        System.out.println(tabulation(n));
    }

    private static int helper(int n) {
        ctr++;
        if (n == 0) return 1;
        if (dp[n] != -1) return dp[n];
        dp[n] = helper(n / 2) + helper(n / 3);
        return dp[n];
    }

    private static int tabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) dp[i] = dp[i / 2] + dp[i / 3];
        return dp[n];
    }
}
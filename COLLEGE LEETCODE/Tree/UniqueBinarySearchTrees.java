public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.println("Memoization: " + numTrees_Memo(i));
            System.out.println("Tabulation: " + numTrees_Tab(i));
        }
    }
    public static int numTrees_Memo(int n) {
        int[] dp = new int[n + 1];
        return helper(n, dp);
    }

    private static int helper(int n, int[] dp) {
        if (n == 0 || n == 1) return 1;
        if (dp[n] != 0) return dp[n];
        for (int i = 1; i <= n; i++) 
            dp[n] += (helper(i - 1, dp) * helper(n - i, dp));
        return dp[n];
    }

    public static int numTrees_Tab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
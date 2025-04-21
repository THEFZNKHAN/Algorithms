public class LCS {
    public static void main(String[] args) {
        String t1 = "abcde";
        String t2 = "ace";
        int n = t1.length();
        int m = t2.length();

        // Tabulation approach
        int[][] dpTab = new int[n + 1][m + 1];
        int lcsLengthTab = lcs_tab(t1, t2, dpTab, n, m);
        System.out.println("LCS length (Tabulation): " + lcsLengthTab);

        // Memoization approach
        int[][] dpMemo = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
            dpMemo[i][j] = -1;
            }
        }
        int lcsLengthMemo = lcs_memo(t1, t2, n, m, dpMemo);
        System.out.println("LCS length (Memoization): " + lcsLengthMemo);
    }

    public static int lcs_tab(String t1, String t2, int[][] dp, int n, int m) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (t1.charAt(i - 1) == t2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    private static int lcs_memo(String t1, String t2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) return 0;
        if (dp[n][m] != -1) return dp[n][m];
        if (t1.charAt(n - 1) == t2.charAt(m - 1)) return dp[n][m] = 1 + lcs_memo(t1, t2, n - 1, m - 1, dp);
        return dp[n][m] = Math.max(lcs_memo(t1, t2, n - 1, m, dp), lcs_memo(t1, t2, n, m - 1, dp));
    }
}

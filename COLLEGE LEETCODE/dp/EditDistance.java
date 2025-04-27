import java.util.Arrays;

class EditDistance {
    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        String word1 = "horse";
        String word2 = "ros";

        int resultTab = ed.minDistance_tab(word1, word2);
        System.out.println("Minimum Edit Distance (Tabulation): " + resultTab);

        int resultMemo = EditDistance.minDistance_memo(word1, word2);
        System.out.println("Minimum Edit Distance (Memoization): " + resultMemo);
    }

    public int minDistance_tab(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) dp[i][0] = i;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = 1 + Math.min(dp[i - 1][j], 
                    Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        }

        return dp[n][m];
    }

    public static int minDistance_memo(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp) Arrays.fill(d, -1);
        return memo(word1, word2, n, m, dp);
    }

    private static int memo(String w1, String w2, int n, int m, int[][] dp) {
        if (n == 0 && m == 0) return 0;
        if (n > 0 && m == 0) return n;
        if (m > 0 && n == 0) return n;
        if (dp[n][m] != -1) return dp[n][m];
        if (w1.charAt(n - 1) == w2.charAt(m - 1)) return memo(w1, w2, n - 1, m - 1, dp);
        return dp[n][m] = 1 + Math.min(memo(w1, w2, n - 1, m, dp),
                Math.min(memo(w1, w2, n, m - 1, dp), memo(w1, w2, n - 1, m - 1, dp)));
    }
}
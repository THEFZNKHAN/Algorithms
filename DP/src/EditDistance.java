import java.util.Arrays;

class EditDistance {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(minDistanceM(word1, word2));
        System.out.println(minDistanceT("horse", "ros"));
        System.out.println(minDistanceS("horse", "ros"));
        System.out.println(minDistanceS("intention", "execution"));
    }

    // USING MEMOIZATION
    private static int minDistanceM(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] memo = new int[n][m];
        for (int[] w : memo) {
            Arrays.fill(w, -1);
        }
        return helper(n - 1, m - 1, word1, word2, memo);
    }

    private static int helper(int n, int m, String str1, String str2, int[][] memo) {
        if (n < 0)
            return m + 1;
        if (m < 0)
            return n + 1;
        if (memo[n][m] != -1)
            return memo[n][m];

        if (str1.charAt(n) == str2.charAt(m)) {
            return memo[n][m] = helper(n - 1, m - 1, str1, str2, memo);
        } else {
            return memo[n][m] = 1 + Math.min(helper(n - 1, m - 1, str1, str2, memo),
                    Math.min(helper(n - 1, m, str1, str2, memo), helper(n, m - 1, str1, str2, memo)));
        }
    }

    // USING TABULATION
    private static int minDistanceT(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[l1][l2];
    }

    // USING SPACE OPTIMIZATION
    private static int minDistanceS(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int[] dp = new int[l2 + 1];

        for (int j = 0; j <= l2; j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= l1; i++) {
            int prev = dp[0];
            dp[0] = i;
            for (int j = 1; j <= l2; j++) {
                int temp = dp[j];
                if (c1[i - 1] == c2[j - 1]) {
                    dp[j] = prev;
                } else {
                    dp[j] = 1 + Math.min(prev, Math.min(dp[j], dp[j - 1]));
                }
                prev = temp;
            }
        }

        return dp[l2];
    }

}
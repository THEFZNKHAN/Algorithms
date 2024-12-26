import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {    
        int ansM = uniquePathsM(10, 6);
        System.out.println("Using Memorization: " + ansM);

        int ansT = uniquePathsT(10, 6);
        System.out.println("Using Memorization: " + ansT);

        int ansS = uniquePathsS(10, 6);
        System.out.println("Using Space Optimization: " + ansS);
    }

    // USING MEMOIZATION (TOP-DOWN) (TC: O(M*N) || SC: O(M*N))
    private static int uniquePathsM(int m, int n) {
        int dp[][] = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return countWaysM(m - 1, n - 1, dp);
    }

    private static int countWaysM(int m, int n, int[][] dp) {
        if (m == 0 || n == 0)
            return 1;
        if (dp[m][n] != -1)
            return dp[m][n];
        return dp[m][n] = countWaysM(m - 1, n, dp) + countWaysM(m, n - 1, dp);
    }

    // USING TABULATION (Bottom UP) (TC: O(M*N) || SC: O(M*N))
    private static int uniquePathsT(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return countWaysT(m, n, dp);
    }

    private static int countWaysT(int m, int n, int[][] dp) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                int up = 0, left = 0;

                if (i > 0)
                    up = dp[i - 1][j];
                if (j > 0)
                    left = dp[i][j - 1];

                dp[i][j] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }

    // USING SPACE OPTIMIZATION (TC: O(M*N) || SC: O(N))
    private static int uniquePathsS(int m, int n) {
        int[] prev = new int[n];
        Arrays.fill(prev, 1);

        for (int i = 1; i < m; i++) {
            int[] curr = new int[n];
            curr[0] = 1;
            for (int j = 1; j < n; j++) {
                curr[j] = curr[j - 1] + prev[j];
            }
            prev = curr;
        }

        return prev[n - 1];
    }
}

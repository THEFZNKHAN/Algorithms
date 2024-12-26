import java.util.ArrayList;
import java.util.List;

class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3, 4));
        triangle.add(List.of(6, 5, 7));
        triangle.add(List.of(4, 1, 8, 3));

        int result = minimumTotalS(triangle); // 11
        System.out.println("The minimum path sum is: " + result);

        int result2 = minimumTotalM(triangle); // 11
        System.out.println("The minimum path sum is: " + result2);
    }

    // USING MEMORIZATION - SPACE OPTIMIZATION (BOTTOM-UP) (TC: O(N^2) || SC: O(N))
    public static int minimumTotalS(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++)
            dp[i] = triangle.get(n - 1).get(i);

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }

    // USING MEMOIZATION (TOP-DOWN) (TC: O(N^2) || SC: O(N^2))
    public static int minimumTotalM(List<List<Integer>> triangle) {
        int n = triangle.size();
        return helper(0, 0, n, new int[n][n], new boolean[n][n], triangle);
    }

    public static int helper(int i, int j, int n, int[][] dp, boolean[][] vis, List<List<Integer>> triangle) {
        if (i == n)
            return 0;

        if (!vis[i][j]) {
            vis[i][j] = true;
            dp[i][j] = Math.min(
                    helper(i + 1, j, n, dp, vis, triangle),
                    helper(i + 1, j + 1, n, dp, vis, triangle)) + triangle.get(i).get(j);
        }

        return dp[i][j];
    }
}
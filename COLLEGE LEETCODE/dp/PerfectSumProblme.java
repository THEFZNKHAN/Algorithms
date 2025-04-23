import java.util.Arrays;

class PerfectSumProblem {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 5;

        System.out.println("Perfect Sum using Tabulation: " + perfectSum_TAB(nums, target));
        System.out.println("Perfect Sum using Memoization: " + perfectSum_MEMO(nums, target));
    }

    // USING 1D DP
    public static int perfectSum_1D(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int sum = target; sum >= num; sum--) {
                dp[sum] += dp[sum - num];
            }
        }

        return dp[target];
    }

    // SPACE OPTIMIZED
    public static int space_optimized(int[] nums, int t) {
        int n = nums.length;
        int[] prev = new int[t + 1];
        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[t + 1];
            for (int sum = 0; sum <= t; sum++) {
                curr[sum] = prev[sum];
                if (nums[i - 1] <= sum)curr[sum] += prev[sum - nums[i - 1]];
            }
            prev = curr;
        }

        return prev[t];
    }

    // TABULATION
    public static int perfectSum_TAB(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        return tab(nums, target, dp, n);
    }

    public static int tab(int[] nums, int t, int[][] dp, int n) {
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int sum = 0; sum <= t; sum++) {
                dp[i][sum] = dp[i - 1][sum];
                if (nums[i - 1] <= sum) dp[i][sum] += dp[i - 1][sum - nums[i - 1]];
            }
        }

        return dp[n][t];
    }

    // MEMOIZATION
    public static int perfectSum_MEMO(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return memo(nums, target, n, dp);
    }

    private static int memo(int[] nums, int t, int i, int[][] dp) {
        if (i == 0) return (t == 0) ? 1 : 0;
        if (dp[i][t] != -1) return dp[i][t];

        int ways = memo(nums, t, i - 1, dp);
        if (nums[i - 1] <= t) ways += memo(nums, t - nums[i - 1], i - 1, dp);

        return dp[i][t] = ways;
    }
}

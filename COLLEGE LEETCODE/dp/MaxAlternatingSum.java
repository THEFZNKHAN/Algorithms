// https://leetcode.com/problems/maximum-alternating-subsequence-sum/description/

import java.util.Arrays;

public class MaxAlternatingSum {
    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 3};
        System.out.println("Max Alternating Sum (Tabulation): " + maxAlternatingSum(nums));
        System.out.println("Max Alternating Sum (Tabulation): " + maxAlternatingSum_Tab(nums));
        System.out.println("Max Alternating Sum (Memoization): " + maxAlternatingSum_Memo(nums));
    }

    public static long maxAlternatingSum(int[] nums) {
        long ans = nums[0];
        for(int i = 1; i < nums.length; i++) ans += Math.max(nums[i] - nums[i - 1],0);
        return ans;
    }

    public static long maxAlternatingSum_Tab(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n + 1][2];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - nums[i - 1], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + nums[i - 1], dp[i - 1][1]);
        }
        return Math.max(dp[n][0], dp[n][1]);
    }

    public static long maxAlternatingSum_Memo(int[] nums) {
        long[][] dp = new long[nums.length][2];
        for (long[] row : dp) Arrays.fill(row, -1);
        return helper(0, nums, dp, true);
    }

    private static long helper(int i, int[] nums, long[][] dp, boolean flag) {
        if (i >= nums.length) return 0;

        int idx = flag ? 0 : 1;
        if (dp[i][idx] != -1) return dp[i][idx];

        long ex = helper(i + 1, nums, dp, flag);
        long in = (flag ? nums[i] : -nums[i]) + helper(i + 1, nums, dp, !flag);

        dp[i][idx] = Math.max(in, ex);
        return dp[i][idx];
    }
}



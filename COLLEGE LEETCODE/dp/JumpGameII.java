public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("Memoization: " + jumpMemo(nums));
        System.out.println("Tabulation: " + jumpTab(nums));
        System.out.println("Greedy: " + jumpGreedy(nums));
    }

    // Memoization O(n^2)
    public static int jumpMemo(int[] nums) {
        int[] dp = new int[nums.length];
        return helper(0, nums, dp);
    }

    private static int helper(int i, int[] nums, int[] dp) {
        if (i >= nums.length - 1) return 0;
        if (dp[i] != 0) return dp[i];
        int min = Integer.MAX_VALUE;
        int len = Math.min(i + nums[i], nums.length - 1);
        for (int j = i + 1; j <= len; j++) {
            int jumps = helper(j, nums, dp);
            if (jumps != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + jumps);
            }
        }
        dp[i] = min;
        return min;
    }

    // Tabulation O(n^2)
    public static int jumpTab(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = n - i;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= n) break;
                dp[i] = Math.min(dp[i], dp[i + j] + 1);
            }
        }
        return dp[0];
    }

    // Greedy O(n)
    public static int jumpGreedy(int[] nums) {
        int s = 0, e = 0, ans = 0;
        while (e < nums.length - 1) {
            int max = 0;
            for (int i = s; i <= e; i++) 
                max = Math.max(max, i + nums[i]);
            s = e + 1;
            e = max;
            ans++;
        }
        return ans;
    }
}

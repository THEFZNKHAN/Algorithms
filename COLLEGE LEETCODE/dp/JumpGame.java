public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("canJump (Memoization): " + canJump_Memo(nums));
        System.out.println("canJump_Tab (Tabulation): " + canJump_Tab(nums));
        System.out.println("canJump_Greedy (Greedy): " + canJump_Greedy(nums));
    }

    // MEMOIZATION O(n^2)
    public static boolean canJump_Memo(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        return helper(0, nums, dp);
    }

    private static boolean helper(int i, int[] nums, int[] dp) {
        if (dp[i] != 0) return dp[i] == 1;

        int len = Math.min(i + nums[i], nums.length - 1);
        for (int j = i + 1; j <= len; j++) {
            if (helper(j, nums, dp)) {
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = -1;
        return false;
    }

    // TABULATION O(n^2)
    private static boolean canJump_Tab(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= n) break;
                dp[i] |= dp[i +j];
            }
        }
        return dp[0];
    }

    // GREEDY O(n)
    private static boolean canJump_Greedy(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) return true;
            if (max < i + 1) return false;
        }
        return false;
    }
}

class TargetSum {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        if (sum < target || (sum - target) % 2 == 1)
            return 0;

        int t = (sum - target) / 2;
        int[] dp = new int[t + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = t; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[t];
    }
}
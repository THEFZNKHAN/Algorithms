import java.util.*;

class CountSubset {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 2, 3, 10, 15, 14, 7, 9, 10, 6, 8, 4, 5, 6 };
        int k = 15;

        // Calculate and print the number of subsets that sum up to k
        System.out.println("The number of subsets found are " + findWays(arr, k));
        System.out.println("The number of subsets found are " + findWaysT(arr, k));
        System.out.println("The number of subsets found are " + findWaysS(arr, k));
    }

    // MEMOIZATION
    static int findWays(int[] num, int k) {
        int n = num.length;
        int dp[][] = new int[n][k + 1];

        for (int row[] : dp)
            Arrays.fill(row, -1);

        return findWaysUtil(n - 1, k, num, dp);
    }

    static int findWaysUtil(int ind, int target, int[] arr, int[][] dp) {
        if (target == 0) return 1;
        if (ind == 0) return arr[0] == target ? 1 : 0;
        if (dp[ind][target] != -1) return dp[ind][target];

        int notTaken = findWaysUtil(ind - 1, target, arr, dp);
        int taken = 0;
        if (arr[ind] <= target) taken = findWaysUtil(ind - 1, target - arr[ind], arr, dp);
        return dp[ind][target] = notTaken + taken;
    }

    // TABULATION METHOD
    static int findWaysT(int[] num, int k) {
        int n = num.length;
        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) dp[i][0] = 1;
        if (num[0] <= k) dp[0][num[0]] = 1;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                int notTaken = dp[ind - 1][target];
                int taken = 0;
                if (num[ind] <= target) taken = dp[ind - 1][target - num[ind]];
                dp[ind][target] = notTaken + taken;
            }
        }
        return dp[n - 1][k];
    }

    // SPACE OPTIMIZATION
    private static int findWaysS(int[] arr, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        if (arr[0] <= target) dp[arr[0]] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = target; j >= arr[i]; j--) {
                if (arr[i] <= j) dp[j] += dp[j - arr[i]];
            }
        }
        return dp[target];
    }
}

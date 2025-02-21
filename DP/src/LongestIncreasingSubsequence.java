import java.util.*;

class LongestIncreasingSubsequence {
    public static void main(String args[]) {
        int arr[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
        int n = arr.length;
        System.out.println("The length of the longest increasing subsequence is " + longestIncreasingSubsequence(arr, n));

        int arr2[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println("The length of the longest increasing subsequence is " + lengthOfLIS(arr2));

        int arr3[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println("The length of the longest increasing subsequence is " + LIS(arr3));
    }

    static int longestIncreasingSubsequence(int arr[], int n) {
        int dp[][] = new int[n][n + 1];
        for (int row[] : dp) Arrays.fill(row, -1);
        return getAns(arr, n, 0, -1, dp);
    }

    private static int getAns(int arr[], int n, int ind, int prev_index, int[][] dp) {
        if (ind == n) return 0;
        if (dp[ind][prev_index + 1] != -1) return dp[ind][prev_index + 1];

        int notTake = 0 + getAns(arr, n, ind + 1, prev_index, dp);
        int take = 0;

        if (prev_index == -1 || arr[ind] > arr[prev_index]) {
            take = 1 + getAns(arr, n, ind + 1, ind, dp);
        }

        dp[ind][prev_index + 1] = Math.max(notTake, take);
        return dp[ind][prev_index + 1];
    }

    private static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n + 1][n + 1];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prev = ind - 1; prev >= -1; prev--) {
                int skip = dp[ind + 1][prev + 1];
                int take = 0;
                if (prev == -1 || nums[ind] > nums[prev]) {
                    take = 1 + dp[ind + 1][ind + 1];
                }
                dp[ind][prev + 1] = Math.max(skip, take);
            }
        }
        return dp[0][0];
    }

    private static int LIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[prev] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
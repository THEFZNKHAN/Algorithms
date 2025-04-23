import java.util.Arrays;

public class SubsetSumProblem {
    public static void main(String[] args) {
        int[][] testCases = {
            {3, 34, 4, 12, 5, 2},
            {1, 2, 3, 7},
            {1, 3, 9, 2},
            {10, 20, 15, 5, 25}
        };
        int[] sums = {9, 6, 5, 30};

        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];
            int sum = sums[i];
            System.out.println("Test Case " + (i + 1) + ": Array = " + Arrays.toString(arr) + ", Sum = " + sum);
            if (isSubsetSum(arr, sum)) System.out.println("Found a subset with given sum (Memoization)");
            else System.out.println("No subset with given sum (Memoization)");
            if (tab(arr, sum)) System.out.println("Found a subset with given sum (Tabulation)");
            else System.out.println("No subset with given sum (Tabulation)");
            if (space_optimized(arr, sum)) System.out.println("Found a subset with given sum (Space Optimized)");
            else System.out.println("No subset with given sum (Space Optimized)");
            System.out.println();
        }
    }

    // SPACE OPTIMIZED
    private static boolean space_optimized(int[] arr, int sum) {
        int n = arr.length;
        boolean[] prev = new boolean[sum + 1];
        prev[0] = true;
    
        for (int i = 1; i <= n; i++) {
            boolean[] curr = new boolean[sum + 1];
            curr[0] = true;
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] > j) curr[j] = prev[j];
                else curr[j] = prev[j] || prev[j - arr[i - 1]];
            }
            prev = curr.clone();
        }
    
        return prev[sum];
    }

    // TABULATION
    private static boolean tab(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
    
        for (int i = 0; i <= n; i++) dp[i][0] = true;
    
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] > j) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
            }
        }
    
        return dp[n][sum];
    }

    // MEMOIZATION
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean[][] memo = new Boolean[n + 1][sum + 1];
        for (Boolean[] row : memo) Arrays.fill(row, null);
        return isSubsetSumHelper(arr, n, sum, memo);
    }

    static Boolean isSubsetSumHelper(int[] arr, int n, int sum, Boolean[][] memo) {
        if (sum == 0) return true;
        if (n == 0) return false;
        if (memo[n][sum] != null) return memo[n][sum];
        if (arr[n - 1] > sum) memo[n][sum] = isSubsetSumHelper(arr, n - 1, sum, memo);
        else memo[n][sum] = isSubsetSumHelper(arr, n - 1, sum, memo) 
            || isSubsetSumHelper(arr, n - 1, sum - arr[n - 1], memo);
        return memo[n][sum];
    }
}

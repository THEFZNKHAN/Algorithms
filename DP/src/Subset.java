import java.util.*;

class Subset {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;

        // Check if there exists a subset with the given target sum
        if (subsetSumToKM(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");

        if (subsetSumToKT(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");

        if (subsetSumToKS(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }

    // *** USING MEMORIZATION ***
    static boolean subsetSumToKM(int n, int k, int[] arr) {
        int dp[][] = new int[n][k + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return subsetSumUtil(n - 1, k, arr, dp);
    }

    static boolean subsetSumUtil(int ind, int target, int[] arr, int[][] dp) {
        if (target == 0)
            return true;
        if (ind == 0)
            return arr[0] == target;
        if (dp[ind][target] != -1)
            return dp[ind][target] != 0;

        boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);

        boolean taken = false;
        if (arr[ind] <= target)
            taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);

        dp[ind][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }

    // *** USING TABULATION ***
    static boolean subsetSumToKT(int n, int k, int[] arr) {
        boolean dp[][] = new boolean[n][k + 1];

        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        if (arr[0] <= k)
            dp[0][arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean notTaken = dp[ind - 1][target];

                boolean taken = false;
                if (arr[ind] <= target)
                    taken = dp[ind - 1][target - arr[ind]];

                dp[ind][target] = notTaken || taken;
            }
        }

        return dp[n - 1][k];
    }

    // *** USING SPACE-OPTIMIZATION ***
    static boolean subsetSumToKS(int n, int k, int[] arr) {
        boolean prev[] = new boolean[k + 1];

        prev[0] = true;

        if (arr[0] <= k) prev[arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            boolean cur[] = new boolean[k + 1];
            cur[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean notTaken = prev[target];
                boolean taken = false;
                if (arr[ind] <= target) taken = prev[target - arr[ind]];
                cur[target] = notTaken || taken;
            }
            prev = cur;
        }

        return prev[k];
    }
}

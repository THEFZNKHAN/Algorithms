// https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1

class MinimumSumPartition {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 11, 5};
        System.out.println("Brute Force: " + minDifferenceBruteForce(arr));
        System.out.println("Memoization: " + minDifferenceMemo(arr));
        System.out.println("Tabulation: " + minDifferenceTabulation(arr));
        System.out.println("Space Optimized: " + minDifferenceOptimized(arr));
    }

    // BRUTE FORCE (T : O(n^2))
    public static int minDifferenceBruteForce(int[] arr) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;
        return helperBruteForce(arr, 0, 0, totalSum);
    }

    private static int helperBruteForce(int[] arr, int index, int currentSum, int totalSum) {
        if (index == arr.length) return Math.abs(totalSum - 2 * currentSum);

        int include = helperBruteForce(arr, index + 1, currentSum + arr[index], totalSum);
        int exclude = helperBruteForce(arr, index + 1, currentSum, totalSum);
        return Math.min(include, exclude);
    }

    // MEMOIZATION
    public static int minDifferenceMemo(int[] arr) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;
        int target = totalSum / 2;
        Integer[][] memo = new Integer[arr.length][target + 1];
        int maxSum = helperMemo(arr, 0, 0, target, memo);
        return totalSum - 2 * maxSum;
    }

    private static int helperMemo(int[] arr, int index, int currentSum, int target, Integer[][] memo) {
        if (index == arr.length) {
            return currentSum <= target ? currentSum : 0;
        }
        if (memo[index][currentSum] != null) {
            return memo[index][currentSum];
        }
        int take = 0;
        if (currentSum + arr[index] <= target) {
            take = helperMemo(arr, index + 1, currentSum + arr[index], target, memo);
        }
        int notTake = helperMemo(arr, index + 1, currentSum, target, memo);
        int max = Math.max(take, notTake);
        memo[index][currentSum] = max;
        return max;
    }

    // TABULATION
    public static int minDifferenceTabulation(int[] arr) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;
        int target = totalSum / 2;
        boolean[][] dp = new boolean[arr.length + 1][target + 1];
        
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            int num = arr[i - 1];
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] |= dp[i - 1][j - num];
                }
            }
        }

        int maxSum = 0;
        for (int j = target; j >= 0; j--) {
            if (dp[arr.length][j]) {
                maxSum = j;
                break;
            }
        }
        return totalSum - 2 * maxSum;
    }

    // SPACE OPTIMIZED
    public static int minDifferenceOptimized(int[] arr) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;
        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }

        int maxSum = 0;
        for (int j = target; j >= 0; j--) {
            if (dp[j]) {
                maxSum = j;
                break;
            }
        }
        return totalSum - 2 * maxSum;
    }
}
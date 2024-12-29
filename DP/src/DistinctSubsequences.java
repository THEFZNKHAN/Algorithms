class DistinctSubsequences {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println("Number of distinct subsequences: " + numDistinct(s, t));
    }

    // RECURSIVE - MEMOIZATION
    // time: O(m * n), space: O(m * n)
    public static int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        Integer[][] memo = new Integer[m][n];
        return numDistinct(s, t, 0, 0, memo);
    }

    private static int numDistinct(String s, String t, int i, int j, Integer[][] memo) {
        int m = s.length(), n = t.length();

        if (j == n) return 1;
        else if (i == m || m - i < n - j) return j == n ? 1 : 0;
        else if (memo[i][j] != null) return memo[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            return memo[i][j] = numDistinct(s, t, i + 1, j + 1, memo) + 
                    numDistinct(s, t, i + 1, j, memo);
        } else {
            return memo[i][j] = numDistinct(s, t, i + 1, j, memo);
        }
    }
}

// SPACE OPTIMIZED - TABULATION

// class Solution {
//     public int numDistinct(String s, String t) {
//         int l1 = s.length(), l2 = t.length();
//         char[] arr1 = s.toCharArray();
//         char[] arr2 = t.toCharArray();
//         int[] dp = new int[l2 + 1];
//         dp[0] = 1;

//         for (int i = 1; i <= l1; i++) {
//             for (int j = l2; j >= 1; j--) {
//                 if (arr1[i - 1] == arr2[j - 1]) dp[j] += dp[j-1];
//             }
//         }
//         return dp[l2];
//     }
// }
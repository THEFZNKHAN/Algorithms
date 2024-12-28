public class MinIncretionPalindrome {
    public static void main(String[] args) {
        String[] testCases = { "ab", "racecar", "aabb", "abcde" };
        for (String testCase : testCases) {
            System.out.println("Minimum insertions needed for \"" + testCase + "\": " + minInsertions(testCase));
        }
    }

    // USING TABULATION (Space Optimized)
    // BEATS 99.55% TC || 97.85% SC
    public static int minInsertions(String s) {
        int n = s.length();
        char[] arr1 = s.toCharArray();
        char[] arr2 = new StringBuffer(s).reverse().toString().toCharArray();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (arr1[i - 1] == arr2[j - 1])
                    dp[j] = prev + 1;
                else
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                prev = temp;
            }
        }
        return n - dp[n];
    }
}

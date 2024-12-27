public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String[][] testCases = {
                { "abcde", "ace" },
                { "abc", "abc" },
                { "abc", "def" },
                { "abcd", "abdc" }
        };

        for (String[] testCase : testCases) {
            String text1 = testCase[0];
            String text2 = testCase[1];
            int result = longestCommonSubsequence(text1, text2);
            System.out.println("LCS of \"" + text1 + "\" and \"" + text2 + "\" is " + result);
        }
    }

    // USING TABULATION (Space Optimized)
    public static int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        int[] dp = new int[l2 + 1];
        for (int i = 1; i <= l1; i++) {
            int prev = 0;
            for (int j = 1; j <= l2; j++) {
                int temp = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        return dp[l2];
    }
}

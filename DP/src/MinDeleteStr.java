class MinDeleteStr {
    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        System.out.println("Minimum deletions to make the strings equal: " + minDistance(word1, word2));

        word1 = "leetcode";
        word2 = "etco";
        System.out.println("Minimum deletions to make the strings equal: " + minDistance(word1, word2));
    }

    // USING TABULATION (Space Optimized)
    // BEATS 99.95% TC || 97.85% SC
    public static int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int[] dp = new int[l2 + 1];

        for (int i = 1; i <= l1; i++) {
            int prev = 0;
            for (int j = 1; j <= l2; j++) {
                int temp = dp[j];
                if (arr1[i - 1] == arr2[j - 1]) dp[j] = prev + 1;
                else dp[j] = Math.max(dp[j], dp[j - 1]);
                prev = temp;
            }
        }
        return (l1 - dp[l2]) + (l2 - dp[l2]);
    }
}
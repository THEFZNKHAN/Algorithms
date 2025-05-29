import java.util.Arrays;

class PalindromicPartitioning {
    public static void main(String[] args) {
        System.out.println(palPartition("ababbbabbababa"));
    }

    static int palPartition(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return rec(s, 0, n - 1, dp);
    }

    private static int rec(String s, int i, int j, int[][] dp) {
        if (i >= j || isPalindrome(s, i, j)) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            if (isPalindrome(s, i, k)) 
                min = Math.min(min, 1 + rec(s, k + 1, j, dp));
        }
        return dp[i][j] = min;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) 
            if (s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }
}

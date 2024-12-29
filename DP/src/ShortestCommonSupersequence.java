public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println("Shortest Common Supersequence: " + shortestCommonSupersequence(s1, s2));
    }

    private static String shortestCommonSupersequence(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (arr1[i - 1] == arr2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = l1, j = l2;
        while (i > 0 && j > 0) {
            if (arr1[i - 1] == arr2[j - 1]) {
                sb.append(arr1[i - 1]);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(arr1[i - 1]);
                i--;
            } else {
                sb.append(arr2[j - 1]);
                j--;
            }
        }

        while (i > 0) sb.append(arr1[--i]);
        while (j > 0) sb.append(arr2[--j]);

        return sb.reverse().toString();
    }
}

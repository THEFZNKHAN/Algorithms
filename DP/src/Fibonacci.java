import java.util.Arrays;

class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        int[] dpM = new int[n + 1];
        Arrays.fill(dpM, -1);

        System.out.println("\nFibonacci Series using memorization method:");
        for (int i = 0; i <= n; i++) {
            System.out.print(fiboM(i, dpM) + " ");
        }

        System.out.println("\n\nFibonacci Series using tabulation method:");
        System.out.println(Arrays.toString(fiboT(n)));

        System.out.println("\nFibonacci Series using space optimized method:");
        System.out.println(fiboS(n));
    }

    // TOP DOWN - MEMORIZATION (Main Problem --> Base Case)
    // TC: O(n), SC: O(n)
    public static int fiboM(int n, int[] dp) {
        if (n == 0 || n == 1)
            return n;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = fiboM(n - 1, dp) + fiboM(n - 2, dp);
    }

    // BOTTOM UP - TABULATION (Base Case --> Main Problem)
    // TC: O(n), SC: O(n)
    public static int[] fiboT(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp;
    }

    // Space Optimization
    // TC: O(n), SC: O(1)
    public static int fiboS(int n) {
        if (n <= 1)
            return n;
        int prev2 = 0, prev1 = 1, curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}
import java.util.Arrays;

class MinCostTickets {
    public static void main(String[] args) {
        int[] days = { 1, 4, 6, 7, 8, 20 };
        int[] costs = { 2, 7, 15 };
        System.out.println(minCostTicketsS(days, costs));
        System.out.println(minCostTickets(days, costs));
    }

    // DP solution
    public static int minCostTicketsS(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[days[n - 1] + 1];
        boolean[] travel = new boolean[days[n - 1] + 1];

        for (int d : days) travel[d] = true;

        for (int i = 1; i < dp.length; i++) {
            if (travel[i])
                dp[i] = Math.min(dp[i - 1] + costs[0],
                        Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]));
            else
                dp[i] = dp[i - 1];
        }

        return dp[days[n - 1]];
    }

    // Recursive solution
    public static int minCostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(0, n, days, costs, dp);
    }

    public static int solve(int i, int n, int[] d, int[] c, int[] dp) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];

        int opt1 = c[0] + solve(i + 1, n, d, c, dp);
        int ni = n;
        for (int q = i; q < n; q++) {
            if (d[i] + 7 <= d[q]) {
                ni = q;
                break;
            }
        }
        int opt2 = c[1] + solve(ni, n, d, c, dp);

        ni = n;
        for (int q = i; q < n; q++) {
            if (d[i] + 30 <= d[q]) {
                ni = q;
                break;
            }
        }
        int opt3 = c[2] + solve(ni, n, d, c, dp);

        int res = Math.min(opt1, Math.min(opt2, opt3));
        dp[i] = res;
        return res;
    }
}
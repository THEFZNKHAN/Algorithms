
import java.util.Arrays;

class MinCostTickets {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};

        System.out.println("Minimum cost using tabulation: " + minCostTickets_tab(days, costs));
        System.out.println("Minimum cost using memoization: " + minCostTickets_memo(days, costs));
    }

    public static int minCostTickets_tab(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            int one = costs[0] + (i + 1 < n ? dp[i + 1] : 0);

            int temp = n;
            for (int j = i; j < n; j++) {
                if (days[j] >= days[i] + 7) {
                    temp = j;
                    break;
                }
            }

            int seven = costs[1] + (temp < n ? dp[temp] : 0);
            temp = n;
            for (int j = i; j < n; j++) {
                if (days[j] >= days[i] + 30) {
                    temp = j;
                    break;
                }
            }

            int thirty = costs[2] + (temp < n ? dp[temp] : 0);
            dp[i] = Math.min(one, Math.min(seven, thirty));
        }

        return dp[0];
    }

    public static int minCostTickets_memo(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(0, n, days, costs, dp);
    }

    private static int helper(int i, int n, int[] d, int[] c, int[] dp) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];

        int one = c[0] + helper(i + 1, n, d, c, dp);

        int temp = n;
        for (int j = i; j < n; j++) {
            if (d[j] >= d[i] + 7) {
                temp = j;
                break;
            }
        }

        int seven = c[1] + helper(temp, n, d, c, dp);

        temp = n;
        for (int j = i; j < n; j++) {
            if (d[j] >= d[i] + 30) {
                temp = j;
                break;
            }
        }

        int thirty = c[2] + helper(temp, n, d, c, dp);

        return dp[i] = Math.min(one, Math.min(seven, thirty));
    }
}
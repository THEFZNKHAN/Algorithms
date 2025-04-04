import java.util.*;

class NinjaGame {
    // USING MEMOIZATION (TOP-DOWN) (TC: O(N*4*3) || SC: O(N) + O(N*4))
    static int calculateMaxPoints(int day, int lastActivity, int[][] points, int[][] dp) {
        if (dp[day][lastActivity] != -1)
            return dp[day][lastActivity];

        if (day == 0) {
            int maxPoints = 0;
            for (int i = 0; i <= 2; i++)
                if (i != lastActivity)
                    maxPoints = Math.max(maxPoints, points[0][i]);
            return dp[day][lastActivity] = maxPoints;
        }

        int maxPoints = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != lastActivity) {
                int activityPoints = points[day][i] + calculateMaxPoints(day - 1, i, points, dp);
                maxPoints = Math.max(maxPoints, activityPoints);
            }
        }

        return dp[day][lastActivity] = maxPoints;
    }

    static int ninjaTrainingM(int n, int[][] points) {
        int dp[][] = new int[n][4];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return calculateMaxPoints(n - 1, 3, points, dp);
    }

    // USING TABULATION (BOTTOM-UP) (TC: O(N*4*3) || SC: O(N*4))
    static int ninjaTrainingT(int n, int[][] points) {
        int[][] dp = new int[n][4];

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        return dp[n - 1][3];
    }

    // USING SPACE OPTIMIZATION (TC: O(N*4*3) || SC: O(4))
    static int ninjaTrainingS(int n, int[][] points) {
        int prev[] = new int[4];

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int temp[] = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }
            prev = temp;
        }

        return prev[3];
    }

    public static void main(String args[]) {
        int[][] points = { { 10, 40, 70 }, { 20, 50, 80 }, { 30, 60, 90 } }; // 210
        int n = points.length;
        System.out.println("NinjaTraining using memoization: " + ninjaTrainingM(n, points));
        System.out.println("NinjaTraining using tabulation: " + ninjaTrainingT(n, points));
        System.out.println("NinjaTraining using Space Optimization: " + ninjaTrainingS(n, points));
    }
}

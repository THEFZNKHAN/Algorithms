class WaysToReachTheStair {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Number of ways to reach " + n + "th stair: " + countWays(n));
    }

    private static int countWays(int n) {
        if (n <= 1) return 1;
        int a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
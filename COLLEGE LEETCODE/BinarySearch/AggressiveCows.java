import java.util.*;

class AggressiveCows {
    public static void main(String[] args) {
        System.out.println(aggressiveCows(new int[]{1, 2, 4, 8, 9}, 3));
        System.out.println(aggressiveCows(new int[]{10, 1, 2, 7, 5}, 3));
        System.out.println(aggressiveCows(new int[]{2, 12, 11, 3, 26, 7}, 5));
    }

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int max = (stalls[stalls.length - 1] - stalls[0]) / (k - 1), s = 0;
        while (s <= max) {
            int m = s + (max - s) / 2;
            if (helper(stalls, m, k, n)) s = m + 1;
            else max = m - 1;
        }
        return max;
    }

    private static boolean helper(int[] stalls,int d, int k, int n) {
        int ctr = 1, last = stalls[0];
        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= d) {
                ctr++;
                last = stalls[i];
            }
            if (ctr >= k) return true;
        }
        return false;
    }
}
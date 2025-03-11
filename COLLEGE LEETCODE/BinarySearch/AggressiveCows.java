import java.util.*;

class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9};
        int k = 3;
        System.out.println(aggressiveCows(stalls, k));
        System.out.println(aggressiveCows(new int[]{10, 1, 2, 7, 5}, 3));
        System.out.println(aggressiveCows(new int[]{2, 12, 11, 3, 26, 7}, 5));
    }
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int max = stalls[stalls.length - 1], ans = 0, s = 0;
        while (s <= max) {
            int m = s + (max - s) / 2;
            if (helper(stalls, m, k)) {
                ans = m;
                s = m + 1;
            } else {
                max = m - 1;
            }
        }
        return ans;
    }

    // public static int aggressiveCows(int[] stalls, int k) {
    //     Arrays.sort(stalls);
    //     int max = stalls[stalls.length - 1], ans = 0;
    //     for (int i = max; i > 0; i--) {
    //         if (helper(stalls, i, k)) {
    //             ans = i;
    //             break;
    //         }
    //     }
    //     return ans;
    // }

    private static boolean helper(int[] stalls,int d, int k) {
        int ctr = 1, last = stalls[0], n = stalls.length;
        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= d) {
                ctr++;
                last = stalls[i];
            }
        }
        return ctr >= k;
    }
} 
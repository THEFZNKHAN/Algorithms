import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        int[] positions = {1, 2, 3, 4, 7};
        int m = 3;
        System.out.println(maxDistance(positions, m));
    }

    public static int maxDistance(int[] pos, int m) {
        Arrays.sort(pos);

        int low = 0, high = (pos[pos.length - 1] - pos[0]) / (m - 1), ans = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (helper(pos, mid, m)) {
                ans = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        return ans;
    }

    public static boolean helper(int[] pos, int dist, int m) {
        int cnt = 1, last = pos[0];
        for (int i = 0; i < pos.length; i++) {
            if (pos[i] - last >= dist) {
                cnt++;
                last = pos[i];
            }
        }
        return cnt >= m;
    }
}

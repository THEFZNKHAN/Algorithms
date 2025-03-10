// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

class CapacityToShip {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        CapacityToShip solution = new CapacityToShip();
        int result = solution.shipWithinDays(weights, days);
        System.out.println("Minimum capacity to ship within " + days + " days: " + result);
    }

    public int shipWithinDays(int[] weights, int days) {
        int s = 0, e = 0;
        for (int w : weights) {
            s = Math.max(s, w);
            e += w;
        }

        while (s < e) {
            int mid = s + (e - s) / 2;
            if (helper(weights, days, mid)) e = mid;
            else s = mid + 1;
        }
        return s;
    }

    private boolean helper(int[] weights, int days, int capacity) {
        int curr = 0, d = 1;

        for (int w : weights) {
            if (curr + w > capacity) {
                d++;
                curr = w;
                if (d > days) return false;
            } else {
                curr += w;
            }
        }
        return d <= days;
    }
}

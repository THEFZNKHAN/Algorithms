// https://leetcode.com/problems/minimum-time-to-repair-cars/?envType=daily-question&envId=2025-03-16

class RepairCars {
    public static void main(String[] args) {
        int[] nums = new int[] { 31, 31, 5, 19, 19, 10, 31, 18, 19, 3, 16, 20, 4, 16, 2, 25, 10, 16, 23, 18, 21, 23, 28,
                6, 7, 29, 11, 11, 19, 20, 24, 19, 26, 12, 29, 29, 1, 14, 17, 26, 24, 7, 11, 28, 22, 14, 31, 12, 3, 19,
                16, 26, 11 };
        System.out.println(repairCars(nums, 736185)); // 2358388332
    }

    public static long repairCars(int[] ranks, int cars) {
        int max = 1;
        for (int r : ranks) max = r > max ? r : max;

        long s = 1, e = (long) max * cars * cars;

        while (s < e) {
            long mid = s + (e - s) / 2;
            if (helper(ranks, cars, mid)) e = mid;
            else s = mid + 1;
        }
        return s;
    }

    private static boolean helper(int[] ranks, int cars, long time) {
        for (int r : ranks) {
            long max = (long) Math.sqrt(time / r);
            cars -= max;
            if (cars <= 0) return true;
        }
        return false;
    }
}
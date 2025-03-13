// https://leetcode.com/problems/zero-array-transformation-ii/

class MinZeroArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[][] q = {{0, 1, 1}, {1, 3, 2}, {0, 2, 1}};
        int result = minZeroArray(nums, q);
        System.out.println("Minimum number of operations: " + result);
    }

    public static int minZeroArray(int[] nums, int[][] q) {
        int n = nums.length, sum = 0, k = 0;
        int[] diff = new int[n + 1];
        for (int i = 0; i < n; i++) {
            while (sum + diff[i] < nums[i]) {
                k++;
                if (k > q.length) return -1;
                int l = q[k - 1][0], r = q[k - 1][1], v = q[k - 1][2];
                if (r >= i) {
                    diff[Math.max(l, i)] += v;
                    diff[r + 1] -= v;
                }
            }
            sum += diff[i];
        }
        return k;
    }
}
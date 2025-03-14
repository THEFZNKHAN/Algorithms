package Array;

class IsZeroArray {
    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 0, 1};
        int[][] queries = {{0, 1}, {3, 4}};
        boolean result = isZeroArray(nums, queries);
        System.out.println("Is zero array: " + result);
    }

    // OPTIMIZED SOLUTION
    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] fq = new int[n + 1];
        for (int[] q : queries) {
            fq[q[0]]++;
            fq[q[1] + 1]--;
        }

        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr += fq[i];
            if (curr < nums[i]) return false;
        }
        return true;
    }
}
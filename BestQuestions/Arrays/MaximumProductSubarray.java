public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray mps = new MaximumProductSubarray();
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum product subarray (method 1): " + mps.maxProduct(nums));
        System.out.println("Maximum product subarray (method 2): " + mps.maxProduct2(nums));
    }

    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            ans = Math.max(ans, max);
        }
        return ans;
    }

    // another approach to solve the same problem
    public int maxProduct2(int[] nums) {
        int n = nums.length;
        double pre = 1, suf = 1;
        double res = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            pre *= nums[i];
            res = Math.max(res, pre);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (suf == 0) suf = 1;
            suf *= nums[i];
            res = Math.max(res, suf);
        }

        return (int) res;
    }
}

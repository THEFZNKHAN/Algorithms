class MaxSubarray {
    public static void main(String[] args) {
        MaxSubarray solution = new MaxSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solution.maxSubArray(nums);
        System.out.println("The maximum subarray sum is: " + result);
    }

    public int maxSubArray(int[] nums) {
        int curr = 0, max = nums[0];
        for (int n : nums) {
            curr += n;
            max = Math.max(curr, max);
            curr = Math.max(0, curr);
        }
        return max;
    }
}

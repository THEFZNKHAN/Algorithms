public class MinSubArrayLen {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = minSubArrayLen(target, nums);
        // "subarray" refers to a contiguous portion of the array.
                System.out.println("The minimum subarray length is: " + result);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, n = nums.length, sum = 0, min = Integer.MAX_VALUE;
        while (r < n) {
            sum += nums[r++];
            while (sum >= target) {
                min = Math.min(min, r - l);
                sum -= nums[l++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

public class MaxScoreSightseeingPair {
    public static void main(String[] args) {
        int[] nums1 = { 8, 1, 5, 2, 6 };
        int[] nums2 = { 1, 3, 5 };
        int[] nums3 = { 4, 7, 5, 8 };
        int[] nums4 = { 10, 2, 9, 1, 5 };

        System.out.println("Max score for nums1: " + maxScore(nums1)); // Expected: 11
        System.out.println("Max score for nums2: " + maxScore(nums2)); // Expected: 7
        System.out.println("Max score for nums3: " + maxScore(nums3)); // Expected: 12
        System.out.println("Max score for nums4: " + maxScore(nums4)); // Expected: 14
    }

    // USING KADANE'S ALGORITHM (DP)
    public static int maxScore(int[] values) {
        int left = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < values.length; i++) {
            max = Math.max(max, left + values[i] - i);
            left = Math.max(left, values[i] + i);
        }
        return max;
    }
}

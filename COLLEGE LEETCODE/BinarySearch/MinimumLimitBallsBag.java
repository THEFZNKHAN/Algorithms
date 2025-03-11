public class MinimumLimitBallsBag {
    public static void main(String[] args) {
        int[] nums = {9, 6, 8, 7};
        int maxOperations = 3;
        int result = minimumSize(nums, maxOperations);
        System.out.println("The minimum possible maximum size of a bag is: " + result);
    }

    public static int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = (int) Math.pow(10, 9);
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (helper(nums, maxOperations, mid)) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    public static boolean helper(int nums[], int max, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > k) max -= (nums[i] - 1) / k;
            if (max < 0) return false;
        }
        return true;
    }
}

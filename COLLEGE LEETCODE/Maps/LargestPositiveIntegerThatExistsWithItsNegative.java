// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description/

public class LargestPositiveIntegerThatExistsWithItsNegative {
    public static void main(String[] args) {
        int[] nums = {3, 2, -2, 5, -3};
        int result = findMaxK(nums);
        System.out.println("Largest positive integer that exists with its negative: " + result);
    }

    public static int findMaxK(int[] nums) {
        boolean[] neg = new boolean[1001];
        for (int x : nums) {
            if (x < 0) neg[-x] = true;
        }

        int max = -1;
        for (int x : nums) {
            if (x > 0 && neg[x] == true) {
                max = Math.max(max, x);
            }
        }
        return max;
    }
}

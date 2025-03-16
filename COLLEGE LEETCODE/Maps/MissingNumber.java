// https://leetcode.com/problems/missing-number/

public class MissingNumber {
    public static void main(String[] args) {
        int[] test1 = { 3, 0, 1 };
        int[] test2 = { 0, 1 };
        int[] test3 = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        int[] test4 = { 0 };

        System.out.println("Missing number in test1: " + missingNumber(test1));
        System.out.println("Missing number in test2: " + missingNumber(test2));
        System.out.println("Missing number in test3: " + missingNumber(test3));
        System.out.println("Missing number in test4: " + missingNumber(test4));

        System.out.println("Missing number in test1: " + missingNumber_(test1));
        System.out.println("Missing number in test2: " + missingNumber_(test2));
        System.out.println("Missing number in test3: " + missingNumber_(test3));
        System.out.println("Missing number in test4: " + missingNumber_(test4));
    }

    public static int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for (int x : nums) sum += x;
        return (n * (n + 1) / 2) - sum;
    }

    // USING BIT MANIPULATION
    public static int missingNumber_(int[] nums) {
        int miss = 0;
        for (int i = 0; i < nums.length; i++) miss ^= (i ^ nums[i]);
        return miss ^ nums.length;
    }
}

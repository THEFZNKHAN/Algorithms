// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/

public class MinStartValue {
    public static void main(String[] args) {
        int[] nums = {-3, 2, -3, 4, 2};
        int result = minStartValue(nums);
        System.out.println("The minimum start value is: " + result);
    }

    public static int minStartValue(int[] nums) {
        int sum = 0, min = 0;
        for (int n : nums) {
            sum += n;
            min = Math.min(min, sum);
        }
        return min < 0 ? -1 * min + 1 : 1;
    }
}

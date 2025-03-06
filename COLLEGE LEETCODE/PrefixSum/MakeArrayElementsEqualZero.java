// https://leetcode.com/problems/make-array-elements-equal-to-zero/description/

public class MakeArrayElementsEqualZero {
    public static void main(String[] args) {
        int[] nums = { 1, 0, 2, 0, 3 };
        int result = countValidSelections(nums);
        System.out.println("Number of valid selections: " + result);
    }

    private static int countValidSelections(int[] nums) {
        int idx = 0, left = 0, right = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            left += nums[i];
            if (nums[i] == 0) {
                idx = i;
                break;
            }
        }

        for (int i = idx + 1; i < n; i++) right += nums[i];

        int ans = 0;
        for (int i = idx; i < n; i++) {
            left += nums[i];
            right -= nums[i];

            if (nums[i] != 0) continue;
            if (left == right) ans += 2;
            else if (Math.abs(left - right) == 1) ans += 1;
        }

        return ans;
    }   
}

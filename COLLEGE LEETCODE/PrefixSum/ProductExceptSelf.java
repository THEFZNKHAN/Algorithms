// https://leetcode.com/problems/product-of-array-except-self/

import java.util.Arrays;

class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int right = 1;
        answer[0] = 1;
        for (int i = 0; i < n - 1; i++) {
            answer[i + 1] = answer[i] * nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }
        return answer;
    }
}

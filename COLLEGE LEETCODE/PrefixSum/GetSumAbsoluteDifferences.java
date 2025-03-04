// https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/description/

import java.util.Arrays;

class GetSumAbsoluteDifferences {

    public static void main(String[] args) {
        int[] nums = {2,3,5};
        System.out.println(Arrays.toString(get(nums)));
    }

    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += Math.abs(nums[i] - nums[j]);
            }
            pre[i] = sum;
        }

        return pre;
    }

    private static int[] get(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suff = new int[n];
        pre[0] =  nums[0];
        suff[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i] + pre[i - 1];
            suff[n - 1 - i] = nums[n - 1 - i] + suff[n - i];
        }

        int[] ans = new int[n];
        ans[0] = (pre[n - 1]) - (n * nums[0]);
        for (int i = 1; i < n; i++) {
            ans[i] = Math.abs(pre[i - 1] - (i)*nums[i] ) + (i + 1 < n ? suff[i + 1] : 0) - (n - 1- i)*nums[i];
        }
        return ans;
    }
}

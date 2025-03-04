// https://leetcode.com/problems/range-sum-query-immutable/

public class RangeOfQuerry {

    int[] arr;

    public RangeOfQuerry(int[] nums) {
        int n = nums.length;
        arr = new int[n];
        arr[0] = nums[0];
        for (int i = 1; i < n; i++) {
            arr[i] = nums[i] + arr[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return arr[right];
        }
        return arr[right] - arr[left - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        RangeOfQuerry obj = new RangeOfQuerry(nums);
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 4));
        System.out.println(obj.sumRange(1, 3));
    }
}

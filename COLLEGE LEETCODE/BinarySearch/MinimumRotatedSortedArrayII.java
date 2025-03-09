// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/

public class MinimumRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums1 = {2, 2, 2, 0, 1};
        int[] nums2 = {1, 3, 5};
        int min1 = findMin(nums1);
        int min2 = findMin(nums2);
        System.out.println("The minimum value in the rotated sorted array is: " + min1);
        System.out.println("The minimum value in the rotated sorted array is: " + min2);
    }

    public static int findMin(int[] nums) {
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == nums[e] && nums[mid] == nums[s]) {
                s++;
                e--;
            } else if (nums[mid] > nums[e]) s = mid + 1;
            else e = mid;
        }
        return nums[s];
    }
}

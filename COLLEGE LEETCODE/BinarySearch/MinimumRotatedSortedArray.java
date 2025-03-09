// Find Minimum in Rotated Sorted Array

public class MinimumRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 1, 2};
        int min = findMin(nums);
        System.out.println("The minimum value in the rotated sorted array is: " + min);
    }

    public static int findMin(int[] nums) {
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] > nums[e]) s = mid + 1;
            else e = mid;
        }
        return nums[s];
    }
}

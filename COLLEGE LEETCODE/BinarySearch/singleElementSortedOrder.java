public class singleElementSortedOrder {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int result = singleNonDuplicate(nums);
        System.out.println("The single non-duplicate element is: " + result);
    }

    public static int singleNonDuplicate(int[] nums) {
        int s = 0, e = nums.length - 1;

        while (s < e) {
            int mid = s + (e - s) / 2;

            if (mid % 2 == 1) mid--;

            if (nums[mid] == nums[mid + 1]) s = mid + 2;
            else e = mid;
        }

        return nums[s];
    }

}

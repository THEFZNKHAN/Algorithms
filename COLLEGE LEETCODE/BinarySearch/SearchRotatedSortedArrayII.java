
class SearchRotatedSortedArrayII {

    public static void main(String[] args) {
        SearchRotatedSortedArrayII solution = new SearchRotatedSortedArrayII();
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        boolean result = solution.search(nums, target);
        System.out.println("Target " + target + " found: " + result);

        target = 3;
        result = solution.search(nums, target);
        System.out.println("Target " + target + " found: " + result);
    }

    public boolean search(int[] nums, int target) {
        int s = 0, e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) return true;

            if (nums[mid] == nums[e]) e--;
            else if (nums[mid] > nums[e]) {
                if (nums[s] <= target && target < nums[mid]) e = mid - 1;
                else s = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[e]) s = mid + 1;
                else e = mid - 1;
            }
        }

        return false;
    }
}

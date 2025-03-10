class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n + 1 - k];
        int maxId = 0, max = Integer.MIN_VALUE, end;

        for (int x = 0; x < k; x++) {
            if (nums[x] >= max) {
                max = nums[x];
                maxId = x;
            }
        }
        ans[0] = max;

        for (int i = 1; i < n - k + 1; i++) {
            end = i + k - 1;

            if (i <= maxId) {
                if (max <= nums[end]) {
                    max = nums[end];
                    maxId = end;
                }
            } else {
                if (nums[end] >= max - 1) {
                    max = nums[end];
                    maxId = end;
                } else if (nums[i] == max - 1 || nums[i] == max) {
                    max = nums[i];
                    maxId = i;
                } else {
                    max = Integer.MIN_VALUE;
                    for (int x = i; x < end + 1; x++) {
                        if (nums[x] >= max) {
                            max = nums[x];
                            maxId = x;
                        }
                    }
                }
            }

            ans[i] = max;
        }

        return ans;
    }
}


// https://leetcode.com/problems/sliding-window-maximum/description/

import java.util.ArrayDeque;
import java.util.Deque;

class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result1 = maxSlidingWindow(nums, k);
        System.out.println("Result using first method:");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] result2 = maxSlidingWindow_2(nums, k);
        System.out.println("Result using second method:");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();
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

    public static int[] maxSlidingWindow_2(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int idx = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.peek() < i - k + 1) q.poll();
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.pollLast();

            q.offer(i);
            if (i >= k - 1) ans[idx++] = nums[q.peek()];
        }
        return ans;
    }
}
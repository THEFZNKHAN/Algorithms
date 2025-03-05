// https://leetcode.com/problems/contiguous-array/description/

import java.util.*;

class ContiguousArray {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 0, 1, 1, 0, 1, 1, 1, 1 };
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        int sum = 0, max = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (m.containsKey(sum)) max = Math.max(max, i - m.get(sum));
            else m.put(sum, i);
        }
        return max;
    }
}

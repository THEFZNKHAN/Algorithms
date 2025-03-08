// https://leetcode.com/problems/max-consecutive-ones-iii/

class LongestOnes {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        int result = longestOnes(nums, k); // 10
        System.out.println("The longest sequence of 1s after flipping at most " + k + " zeros is: " + result);
    }

    public static int longestOnes(int[] nums, int k) {
        int i = 0, z = 0, max = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) z++;
            while (z > k) {
                if (nums[i] == 0) z--;
                i++;
            }
            if (j - i + 1 > max) max = j - i + 1;
        }
        return max;
    }
}

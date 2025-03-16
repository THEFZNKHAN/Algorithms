// https://leetcode.com/problems/number-of-good-pairs/

public class NumberGoodPairs {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
        int result = numIdenticalPairs(nums);
        System.out.println("Number of good pairs: " + result);
    }

    public static int numIdenticalPairs(int[] nums) {
        int[] f = new int[101];
        int ans = 0;
        for (int i : nums) f[i]++;        
        for (int i : f) ans += (i * (i - 1) / 2);
        return ans;
    }
}

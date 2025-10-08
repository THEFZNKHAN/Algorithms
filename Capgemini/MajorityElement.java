public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };
        System.out.println(majorityElement(nums));
    }

    private static int majorityElement(int[] nums) {
        int cnt = 0;
        int val = -1;
        for (int n : nums) {
            if (cnt == 0) {
                val = n;
            }
            cnt += (n == val) ? 1 : -1;
        }
        return val;
    }
}

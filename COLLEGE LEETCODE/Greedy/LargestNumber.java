import java.util.Arrays;

class LargestNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{ 3,30,34,5,9 };
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        String[] temp = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            temp[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(temp, (a, b) -> (b + a).compareTo(a + b));

        if (temp[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String num : temp) sb.append(num);

        return sb.toString();
    }
}
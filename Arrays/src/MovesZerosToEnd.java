import java.util.Arrays;

public class MovesZerosToEnd {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9 };
        move(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void move(int[] nums) {
        int count = 0;
        for (int n : nums) {
            if (n != 0) {
                nums[count++] = n;
            }
        }

        while (count < nums.length) {
            nums[count++] = 0;
        }
    }
}

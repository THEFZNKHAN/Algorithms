// https://leetcode.com/proballslems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/

import java.util.Arrays;

class MinOperations {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(minOperations("110")));
        System.out.println(Arrays.toString(minOperations("001011")));
    }

    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        char[] arr = boxes.toCharArray();

        int balls = 0, operations = 0;
        for (int i = 0; i < n; i++) {
            ans[i] += operations;
            balls += arr[i] == '1' ? 1 : 0;
            operations += balls;
        }

        balls = 0;
        operations = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] += operations;
            balls += arr[i] == '1' ? 1 : 0;
            operations += balls;
        }

        return ans;
    }
}
// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

public class MaxScore {
    public static void main(String[] args) {
        MaxScore maxScore = new MaxScore();
        int[] points = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println("Maximum score (not optimal): " + maxScore.maxScore_(points, k));
        System.out.println("Maximum score (optimal): " + maxScore.maxScore(points, k));
    }

    // not optimal solution:
    public int maxScore_(int[] points, int k) {
        int n = points.length;
        int[] left = new int[k + 1];
        int[] right = new int[k + 1];

        for (int i = 1; i <= k; i++) {
            left[i] = left[i - 1] + points[i - 1];
            right[i] = right[i - 1] + points[n - i];
        }

        int max = 0;
        for (int i = k; i >= 0; i--) {
            int curr = left[i] + right[k - i];
            max = Math.max(max, curr);
        }
        return max;
    }

    // OPTIMAL SOLUTION (BOTH TIME AND SPACE)
    public int maxScore(int[] arr, int k) {
        int n = arr.length;
        int l = 0, r = n - 1;

        int i = 0;
        while (i < k) l += arr[i++];

        int max = l;
        i = k - 1;
        while (i >= 0) {
            l = l - arr[i--] + arr[r--];
            if (l > max) max = l;
        }
        return max;
    }
}

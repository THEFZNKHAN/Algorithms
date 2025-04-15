public class MaxCircularSubarraySum {
    public static void main(String[] args) {
        int arr[] = {8, -4, 3, -5, 4};
        int result = circularSubarraySum(arr);
        System.out.println("Maximum Circular Subarray Sum: " + result);
    }

    public static int circularSubarraySum(int arr[]) {
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
        int ts = 0, currMax = 0, currMin = 0;
        for (int num : arr) {
            currMax = Math.max(currMax + num, num);
            currMin = Math.min(currMin + num, num);
            maxSum = Math.max(maxSum, currMax);
            minSum = Math.min(minSum, currMin);
            ts += num;
        }
        return maxSum > 0 ? Math.max(maxSum, ts - minSum) : maxSum;
    }
}

// https://www.geeksforgeeks.org/problems/largest-number-with-given-sum-1587115620/1

class LargestNumberWithGivenSum {
    public static void main(String[] args) {
        System.out.println(largestNumber(6, 0));
        System.out.println(largestNumber(5, 12));
        System.out.println(largestNumber(3, 29));
    }

    private static String largestNumber(int n, int sum) {
        if (sum == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) sb.append("0");
            return sb.toString();
        }

        if (sum > 9 * n) return "-1";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (sum >= 9) {
                sb.append("9");
                sum -= 9;
            } else if (sum > 0) {
                sb.append(Integer.toString(sum));
                sum = 0;
            } else {
                sb.append("0");
            }
        }
        return sb.toString();
    }
}

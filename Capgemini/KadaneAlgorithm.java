public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(max(arr));
    }

    private static int max(int[] arr) {
        int max = 0, curr = 0;
        for (int a : arr) {
            curr += a;
            max = Math.max(max, curr);
            curr = Math.max(curr, 0);
        }
        return max;
    }
}

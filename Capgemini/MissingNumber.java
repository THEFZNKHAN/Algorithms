public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        System.out.println(missingNumber(arr));
    }

    private static int missingNumber(int[] arr) {
        int n = arr.length;
        int sum = 0, total = (n * (n + 1) / 2);
        for (int a : arr) sum += a;
        return total - sum;
    }
}

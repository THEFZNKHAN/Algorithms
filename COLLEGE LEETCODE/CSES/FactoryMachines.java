import java.util.Scanner;

class FactoryMachines {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int t = sc.nextInt();

            int[] arr = new int[n];
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] < min) min = arr[i];
                if (arr[i] > max) max = arr[i];
            }

            long s = min, e = (long) max * t, ans = 0;
            while (s <= e) {
                long mid = s + (e - s) / 2;
                if (helper(arr, t, mid)) {
                    e = mid - 1;
                    ans = mid;
                } else s = mid + 1;
            }

            System.out.println(ans);
        }
    }

    private static boolean helper(int[] arr, int t, long k) {
        for (int n : arr) {
            t -= (k / n);
            if (t <= 0) return true;
        }
        return false;
    }
}
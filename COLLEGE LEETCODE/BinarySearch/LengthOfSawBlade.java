import java.io.*;
import java.util.Arrays;

public class LengthOfSawBlade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[] trees = new int[N];
        line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(line[i]);
        }

        Arrays.sort(trees);
        long[] sum = new long[N];
        sum[N - 1] = trees[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + trees[i];
        }

        int low = 0;
        int high = trees[N - 1];
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long wood = compute(mid, trees, sum);
            if (wood >= M) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static long compute(int H, int[] trees, long[] sum) {
        int pos = helper(trees, H);
        if (pos >= trees.length) return 0;
        return sum[pos] - (long) H * (trees.length - pos);
    }

    private static int helper(int[] trees, int H) {
        int low = 0;
        int high = trees.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (trees[mid] <= H) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}

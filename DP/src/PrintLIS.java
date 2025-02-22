import java.util.ArrayList;
import java.util.Arrays;

public class PrintLIS {

    public static void main(String[] args) {
        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = arr.length;
        printLIS(arr, n);
    }

    private static int printLIS(int arr[], int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        Arrays.fill(hash, 1);

        for (int i = 0; i <= n - 1; i++) {
            hash[i] = i;
            for (int prev = 0; prev <= i - 1; prev++) {
                if (arr[prev] < arr[i] && dp[i] < dp[prev] + 1) {
                    dp[i] = dp[prev] + 1;
                    hash[i] = prev;
                }
            }
        }

        int ans = -1;
        int last = -1;

        for (int i = 0; i < n; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                last = i;
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[last]);

        while (hash[last] != last) {
            last = hash[last];
            temp.add(arr[last]);
        }

        System.out.print("The subsequence elements are: [");
        for (int i = temp.size() - 1; i >= 0; i--) {
            System.out.print(temp.get(i) + ", ");
        }
        System.out.println("\b\b]");

        return ans;
    }
}

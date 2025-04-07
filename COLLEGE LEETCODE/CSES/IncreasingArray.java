import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            long ans = 0;
            int prev = 0;
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                ans += (prev > val ? prev - val : 0);
                prev = Math.max(prev, val);
            }
            System.out.println(ans);
        }
    }
}

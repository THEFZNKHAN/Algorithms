import java.util.Scanner;

public class TrailingZeros {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int ans = 0;
            while (n != 0) {
                n /= 5;
                ans += n;
            }
            System.out.println(ans);
        }
    }
}

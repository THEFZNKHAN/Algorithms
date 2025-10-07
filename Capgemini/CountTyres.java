import java.util.Scanner;

public class CountTyres {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                int c = sc.nextInt();
                int b = sc.nextInt();

                int ans = count(c, b);
                System.out.println(ans);
            }
        }
    }

    private static int count(int c, int b) {
        return (c * 4) + (b * 2);
    }
}
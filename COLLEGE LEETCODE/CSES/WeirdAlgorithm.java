import java.util.Scanner;

public class WeirdAlgorithm {

    public static void main(String[] args) {
        long n;
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextLong();
        }

        System.out.print(n + " ");
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (n * 3) + 1;
            }
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

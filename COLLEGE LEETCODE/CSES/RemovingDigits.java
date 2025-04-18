import java.util.Scanner;

class RemovingDigits {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int ctr = 0;
            while (n != 0) {
                ctr++;
                n -= max(n);
            }
            System.out.println(ctr);
        }
    }

    private static int max(int n) {
        int max = Integer.MIN_VALUE;
        while (n != 0) {
            if (n % 10 > max) max = n % 10;
            n /= 10;
        }
        return max;
    }
}

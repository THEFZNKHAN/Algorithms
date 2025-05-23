import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TowerOfHanoi {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            System.out.println((1 << n) - 1);
            toh(n, 1, 3, 2);
        }
    }

    private static void toh(int n, int s, int d, int o) {
        if (n == 0) return;
        toh(n - 1, s, o, d);
        System.out.println(s + " " + d);
        toh(n - 1, o, d, s);
    }
}
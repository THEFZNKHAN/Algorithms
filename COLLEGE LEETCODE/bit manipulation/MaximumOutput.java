import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumOutput {
    public static void main(String[] args) throws  IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] bits = new int[n];

            for (int i = 0; i < n; i++) {
                int m = Integer.parseInt(br.readLine());
                String[] strs = br.readLine().split(" ");
                for (int j = 0; j < m && j < strs.length; j++) {
                    bits[i] ^= (1 << (Integer.parseInt(strs[j]) - 1));
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.println(bits[i] + " -> " + binary(bits[i]));
            }
            int[] maxResult = max(bits, n);
            System.out.println("Max count: " + maxResult[0] + ", W1: " + maxResult[1] + ", W2: " + maxResult[2]);
        }
    }

    private static String binary(int n) {
        StringBuilder sb = new StringBuilder();
        if (n == 0) return "0";
        while (n > 0) {
            sb.append(n % 2);
            n >>= 1;
        }
        return sb.reverse().toString();
    }

    private static int[] max(int[] bits, int n) {
        int ctr = 0;
        int w1 = 0, w2 = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int data = bits[i] & bits[j];
                int c = 0;
                while (data > 0) {
                    c++;
                    data &= (data - 1);
                }
                if (c > ctr) {
                    ctr = c;
                    w1 = i;
                    w2 = j;
                }
            }
        }

        return new int[]{ctr, w1, w2};
    }
}
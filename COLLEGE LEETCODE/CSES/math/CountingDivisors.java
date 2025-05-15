import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountingDivisors {
    public static void main(String[] args) throws IOException {
        int max = 1000000;
        int[] divisors = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                divisors[j]++;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(divisors[x]).append('\n');
        }
        System.out.print(sb);
    }
}
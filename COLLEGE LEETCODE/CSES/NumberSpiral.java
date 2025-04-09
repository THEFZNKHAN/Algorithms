import java.io.*;
import java.util.*;

public class NumberSpiral {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.trim().split("\\s+");
            for (String part : parts) {
                if (!part.isEmpty()) list.add(part);
            }
        }

        String[] idx = list.toArray(String[]::new);
        int t = Integer.parseInt(idx[0]);
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= t; i++) {
            long y = Long.parseLong(idx[2 * i - 1]);
            long x = Long.parseLong(idx[2 * i]);
            long n = Math.max(y, x);
            long res;
            if (n % 2 == 0) {
                if (y == n) res = n * n - (x - 1);
                else res = n * n - (n - 1) - (n - y);
            } else {
                if (x == n) res = n * n - (y - 1);
                else res = (n - 1) * (n - 1) + x;
            }
            ans.append(res).append('\n');
        }
        System.out.print(ans);
    }
}
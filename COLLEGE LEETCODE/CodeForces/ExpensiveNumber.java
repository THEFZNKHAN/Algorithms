// https://codeforces.com/problemset/problem/2093/B

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExpensiveNumber {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader((new InputStreamReader(System.in)))) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                char[] c = br.readLine().toCharArray();
                int ctr = 0;
                int e = c.length - 1;
                while (c[e] == '0') {
                    ctr++;
                    e--;
                }

                for (int j = 0; j < e; j++) {
                    if (c[j] != '0') ctr++;
                }
                sb.append(ctr).append("\n");
            }

            System.out.println(sb);
        }
    }
}
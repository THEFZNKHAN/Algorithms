// https://codeforces.com/problemset/problem/2034/B

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RakhshsRevival {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            while (t-- > 0) {
                String[] temp = br.readLine().split(" ");
                char[] ch = br.readLine().toCharArray();

                int n = Integer.parseInt(temp[0]);
                int m = Integer.parseInt(temp[1]);
                int k = Integer.parseInt(temp[2]);

                int last = -1;
                int ctr = 0;

                for (int j = 0; j < n; j++) {
                    if (ch[j] == '1') {
                        last = j;
                    } else {
                        if (j >= m - 1) {
                            int s = j - m + 1;
                            if (last < s) {
                                ctr++;
                                int e = Math.min(j + k - 1, n - 1);
                                last = e;
                                j = e;
                            }
                        }
                    }
                }
                sb.append(ctr).append("\n");
            }
            System.out.println(sb);
        }
    }
}